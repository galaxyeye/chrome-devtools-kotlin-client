@file:Suppress("UNCHECKED_CAST")

package ai.platon.browser4.chrome.protocol.transport

import ai.platon.browser4.chrome.BrowserDevTools
import ai.platon.browser4.chrome.Transport
import ai.platon.browser4.chrome.util.*
import ai.platon.browser4.chrome.protocol.support.EventHandler
import ai.platon.browser4.chrome.protocol.support.EventListener
import ai.platon.browser4.api.model.DevToolsConfig
import ai.platon.browser4.api.model.MethodInvocation
import ai.platon.pulsar.common.warnForClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.serialization.json.JsonElement
import org.slf4j.LoggerFactory
import java.io.IOException
import java.time.Duration
import java.time.Instant
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

internal class ChromeDevToolsImpl(
    private val browserTransport: Transport,
    private val pageTransport: Transport,
    private val config: DevToolsConfig
) : BrowserDevTools {

    companion object {
        private val startTime = Instant.now()
        private var lastActiveTime = startTime
        private val idleTime get() = Duration.between(lastActiveTime, Instant.now())
    }

    private val logger = LoggerFactory.getLogger(ChromeDevToolsImpl::class.java)

    private val closeLatch = CountDownLatch(1)
    private val closed = AtomicBoolean()
    override val isOpen get() = !closed.get() && pageTransport.isOpen

    private val dispatcher = EventDispatcher()

    init {
        browserTransport.addMessageHandler(dispatcher)
        pageTransport.addMessageHandler(dispatcher)
    }

    // ── BrowserDevTools command methods ──────────────────────────────────────

    @Throws(ChromeIOException::class, ChromeRPCException::class)
    override suspend operator fun <T : Any> invoke(
        method: String, params: Map<String, Any?>?, returnClass: KClass<T>, returnProperty: String?
    ): T? {
        val invocation = DevToolsInvocationHandler.createMethodInvocation(method, params)

        // Non-blocking
        val message = dispatcher.serialize(invocation.id, invocation.method, invocation.params, null)

        val rpcResult = sendAndReceive(invocation.id, method, returnProperty, message) ?: return null
        val jsonElement = rpcResult.result ?: return null

        return dispatcher.deserialize(returnClass.java, jsonElement)
    }

    @Throws(ChromeRPCException::class)
    override suspend fun <T> invoke(
        clazz: Class<T>,
        returnProperty: String?,
        returnTypeClasses: Array<Class<out Any>>?,
        method: MethodInvocation
    ): T? = invokeInternal(clazz, returnProperty, returnTypeClasses, method, null)

    @Throws(ChromeRPCException::class)
    internal suspend fun <T> invokeInternal(
        clazz: Class<T>,
        returnProperty: String?,
        returnTypeClasses: Array<Class<out Any>>?,
        method: MethodInvocation,
        mockRpcResult: RpcResult? = null
    ): T? {
        val message = dispatcher.serialize(method)
        val rpcResult = mockRpcResult ?: sendAndReceive(method.id, method.method, returnProperty, message)

        if (rpcResult == null) {
            val methodName = method.method
            val readTimeout = config.readTimeout
            throw ChromeRPCTimeoutException("No response | $methodName | ($readTimeout)")
        }

        return when {
            !rpcResult.isSuccess -> {
                handleFailedFurther(rpcResult.result).let { e ->
                    if (e.errorCode != -32000L) {
                        logger.info(
                            "Protocol return error. errorCode={}, errorMessage={} | request={}",
                            e.errorCode,
                            e.errorMessage,
                            message
                        )
                    }
                    throw e
                }
            }

            Void.TYPE == clazz -> null
            rpcResult.result == null -> null
            returnTypeClasses != null -> dispatcher.deserialize(returnTypeClasses, clazz, rpcResult.result)
            else -> dispatcher.deserialize(clazz, rpcResult.result)
        }
    }

    @Throws(ChromeIOException::class)
    private suspend fun sendAndReceive(
        methodId: Long, method: String, returnProperty: String?, rawMessage: String
    ): RpcResult? {
        val future = dispatcher.subscribe(methodId, returnProperty)

        sendToBrowser(method, rawMessage)

        val timeoutMillis = config.readTimeout.toMillis()
        val result = withTimeoutOrNull(timeoutMillis.milliseconds) { future.deferred.await() }
        if (result == null) {
            dispatcher.unsubscribe(methodId)
        }

        return result
    }

    private suspend fun sendToBrowser(method: String, message: String) {
        if (method.startsWith("Target.")) {
            browserTransport.send(message)
        } else {
            pageTransport.send(message)
        }
    }

    @Throws(ChromeRPCException::class, IOException::class)
    private fun handleFailedFurther(result: RpcResult): CDPReturnError {
        return handleFailedFurther(result.result)
    }

    @Throws(ChromeRPCException::class, IOException::class)
    private fun handleFailedFurther(error: JsonElement?): CDPReturnError {
        val errorObj = dispatcher.deserialize<ErrorObject>(ErrorObject::class.java, error)
        val sb = StringBuilder(errorObj.message)
        if (errorObj.data != null) {
            sb.append(": ")
            sb.append(errorObj.data)
        }

        return CDPReturnError(errorObj.code, errorObj.data, errorObj.message, sb.toString())
    }

    override fun addEventListener(
        domainName: String,
        eventName: String, eventHandler: EventHandler<Any>, eventType: Class<*>
    ): EventListener {
        val key = "$domainName.$eventName"
        val listener = DevToolsEventListener(key, eventHandler, eventType, this)
        dispatcher.registerListener(key, listener)
        return listener
    }

    override fun removeEventListener(eventListener: EventListener) {
        val listener = eventListener as DevToolsEventListener
        dispatcher.unregisterListener(listener.key, listener)
    }

    override fun awaitTermination() {
        try {
            closeLatch.await()
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }
    }

    override fun close() {
        if (closed.compareAndSet(false, true)) {
            runCatching { runBlocking { doClose() } }.onFailure { warnForClose(this, it) }
            closeLatch.countDown()
        }
    }

    @Throws(Exception::class)
    private suspend fun doClose() {
        val shutdownWaitTimeout = if (pageTransport.isOpen || browserTransport.isOpen) {
            Duration.ofSeconds(10)
        } else {
            Duration.ofSeconds(3)
        }

        waitUntilIdle(shutdownWaitTimeout)

        logger.debug("Closing devtools client ...")

        pageTransport.close()
        browserTransport.close()
    }

    private suspend fun waitUntilIdle(timeout: Duration) {
        val endTime = Instant.now().plus(timeout)
        while (dispatcher.hasFutures() && Instant.now().isBefore(endTime)) {
            delay(1.seconds)
        }
    }
}
