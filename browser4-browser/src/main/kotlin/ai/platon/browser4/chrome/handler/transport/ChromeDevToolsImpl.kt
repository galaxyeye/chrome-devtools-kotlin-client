@file:Suppress("UNCHECKED_CAST")

package ai.platon.browser4.chrome.handler.transport

import ai.platon.browser4.chrome.RemoteDevTools
import ai.platon.browser4.chrome.Transport
import ai.platon.browser4.chrome.util.*
import ai.platon.cdt.kt.serialization.protocol.commands.*
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.pulsar.browser.impl.DevToolsConfig
import ai.platon.pulsar.browser.impl.MethodInvocation
import ai.platon.pulsar.common.config.AppConstants
import ai.platon.pulsar.common.readable
import ai.platon.pulsar.common.warnForClose
import com.codahale.metrics.Gauge
import com.codahale.metrics.SharedMetricRegistries
import kotlinx.serialization.json.JsonElement
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import org.slf4j.LoggerFactory
import java.io.IOException
import java.lang.reflect.Proxy
import java.time.Duration
import java.time.Instant
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

internal class ChromeDevToolsImpl(
    private val browserTransport: Transport,
    private val pageTransport: Transport,
    private val config: DevToolsConfig
) : RemoteDevTools, AutoCloseable {

    companion object {
        private val startTime = Instant.now()
        private var lastActiveTime = startTime
        private val idleTime get() = Duration.between(lastActiveTime, Instant.now())

        private val metrics = SharedMetricRegistries.getOrCreate(AppConstants.DEFAULT_METRICS_NAME)
        private val metricsPrefix = "c.i.BasicDevTools.global"
        private val numInvokes = metrics.counter("$metricsPrefix.invokes")
        val numAccepts = metrics.counter("$metricsPrefix.accepts")
        private val gauges = mapOf(
            "idleTime" to Gauge { idleTime.readable() }
        )

        init {
            gauges.forEach { (name, gauge) -> metrics.gauge("$metricsPrefix.$name") { gauge } }
        }
    }

    private val logger = LoggerFactory.getLogger(ChromeDevToolsImpl::class.java)

    private val closeLatch = CountDownLatch(1)
    private val closed = AtomicBoolean()
    override val isOpen get() = !closed.get() && pageTransport.isOpen

    private val dispatcher = EventDispatcher()

    // Domain proxy support — replaces javassist-based CachedDevToolsInvocationHandlerProxies
    private val domainHandler = DevToolsInvocationHandler(this).also { it.devTools = this }
    private val domainProxies = ConcurrentHashMap<Class<*>, Any>()

    private fun <T> getOrCreateDomainProxy(clazz: Class<T>): T {
        return domainProxies.computeIfAbsent(clazz) {
            Proxy.newProxyInstance(clazz.classLoader, arrayOf(clazz), domainHandler)
        } as T
    }

    init {
        browserTransport.addMessageHandler(dispatcher)
        pageTransport.addMessageHandler(dispatcher)
    }

    // ── ChromeDevTools domain accessors ──────────────────────────────────────

    override val console: Console get() = getOrCreateDomainProxy(Console::class.java)
    override val debugger: Debugger get() = getOrCreateDomainProxy(Debugger::class.java)
    override val heapProfiler: HeapProfiler get() = getOrCreateDomainProxy(HeapProfiler::class.java)
    override val profiler: Profiler get() = getOrCreateDomainProxy(Profiler::class.java)
    override val runtime: Runtime get() = getOrCreateDomainProxy(Runtime::class.java)
    override val schema: Schema get() = getOrCreateDomainProxy(Schema::class.java)
    override val accessibility: Accessibility get() = getOrCreateDomainProxy(Accessibility::class.java)
    override val ads: Ads get() = getOrCreateDomainProxy(Ads::class.java)
    override val animation: Animation get() = getOrCreateDomainProxy(Animation::class.java)
    override val audits: Audits get() = getOrCreateDomainProxy(Audits::class.java)
    override val autofill: Autofill get() = getOrCreateDomainProxy(Autofill::class.java)
    override val backgroundService: BackgroundService get() = getOrCreateDomainProxy(BackgroundService::class.java)
    override val bluetoothEmulation: BluetoothEmulation get() = getOrCreateDomainProxy(BluetoothEmulation::class.java)
    override val browser: Browser get() = getOrCreateDomainProxy(Browser::class.java)
    override val css: CSS get() = getOrCreateDomainProxy(CSS::class.java)
    override val cacheStorage: CacheStorage get() = getOrCreateDomainProxy(CacheStorage::class.java)
    override val cast: Cast get() = getOrCreateDomainProxy(Cast::class.java)
    override val crashReportContext: CrashReportContext get() = getOrCreateDomainProxy(CrashReportContext::class.java)
    override val dom: DOM get() = getOrCreateDomainProxy(DOM::class.java)
    override val domDebugger: DOMDebugger get() = getOrCreateDomainProxy(DOMDebugger::class.java)
    override val domSnapshot: DOMSnapshot get() = getOrCreateDomainProxy(DOMSnapshot::class.java)
    override val domStorage: DOMStorage get() = getOrCreateDomainProxy(DOMStorage::class.java)
    override val deviceAccess: DeviceAccess get() = getOrCreateDomainProxy(DeviceAccess::class.java)
    override val deviceOrientation: DeviceOrientation get() = getOrCreateDomainProxy(DeviceOrientation::class.java)
    override val emulation: Emulation get() = getOrCreateDomainProxy(Emulation::class.java)
    override val eventBreakpoints: EventBreakpoints get() = getOrCreateDomainProxy(EventBreakpoints::class.java)
    override val extensions: Extensions get() = getOrCreateDomainProxy(Extensions::class.java)
    override val fedCm: FedCm get() = getOrCreateDomainProxy(FedCm::class.java)
    override val fetch: Fetch get() = getOrCreateDomainProxy(Fetch::class.java)
    override val fileSystem: FileSystem get() = getOrCreateDomainProxy(FileSystem::class.java)
    override val headlessExperimental: HeadlessExperimental get() = getOrCreateDomainProxy(HeadlessExperimental::class.java)
    override val io: IO get() = getOrCreateDomainProxy(IO::class.java)
    override val indexedDb: IndexedDB get() = getOrCreateDomainProxy(IndexedDB::class.java)
    override val input: Input get() = getOrCreateDomainProxy(Input::class.java)
    override val inspector: Inspector get() = getOrCreateDomainProxy(Inspector::class.java)
    override val layerTree: LayerTree get() = getOrCreateDomainProxy(LayerTree::class.java)
    override val log: Log get() = getOrCreateDomainProxy(Log::class.java)
    override val media: Media get() = getOrCreateDomainProxy(Media::class.java)
    override val memory: Memory get() = getOrCreateDomainProxy(Memory::class.java)
    override val network: Network get() = getOrCreateDomainProxy(Network::class.java)
    override val overlay: Overlay get() = getOrCreateDomainProxy(Overlay::class.java)
    override val pwa: PWA get() = getOrCreateDomainProxy(PWA::class.java)
    override val page: Page get() = getOrCreateDomainProxy(Page::class.java)
    override val performance: Performance get() = getOrCreateDomainProxy(Performance::class.java)
    override val performanceTimeline: PerformanceTimeline get() = getOrCreateDomainProxy(PerformanceTimeline::class.java)
    override val preload: Preload get() = getOrCreateDomainProxy(Preload::class.java)
    override val security: Security get() = getOrCreateDomainProxy(Security::class.java)
    override val serviceWorker: ServiceWorker get() = getOrCreateDomainProxy(ServiceWorker::class.java)
    override val smartCardEmulation: SmartCardEmulation get() = getOrCreateDomainProxy(SmartCardEmulation::class.java)
    override val storage: Storage get() = getOrCreateDomainProxy(Storage::class.java)
    override val systemInfo: SystemInfo get() = getOrCreateDomainProxy(SystemInfo::class.java)
    override val target: ai.platon.cdt.kt.serialization.protocol.commands.Target get() = getOrCreateDomainProxy(ai.platon.cdt.kt.serialization.protocol.commands.Target::class.java)
    override val tethering: Tethering get() = getOrCreateDomainProxy(Tethering::class.java)
    override val tracing: Tracing get() = getOrCreateDomainProxy(Tracing::class.java)
    override val webAudio: WebAudio get() = getOrCreateDomainProxy(WebAudio::class.java)
    override val webAuthn: WebAuthn get() = getOrCreateDomainProxy(WebAuthn::class.java)
    override val webMcp: WebMCP get() = getOrCreateDomainProxy(WebMCP::class.java)

    // ── RemoteDevTools command methods ───────────────────────────────────────

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
        numInvokes.inc()

        val message = dispatcher.serialize(method)
        val rpcResult = mockRpcResult ?: sendAndReceive(method.id, method.method, returnProperty, message)

        if (rpcResult == null) {
            val methodName = method.method
            val readTimeout = config.readTimeout
            throw ChromeRPCTimeoutException("No response | $methodName | #${numInvokes.count}, ($readTimeout)")
        }

        return when {
            !rpcResult.isSuccess -> {
                handleFailedFurther(rpcResult.result).let { e ->
                    if (e.errorCode != -32000L) {
                        logger.info("Protocol return error. errorCode={}, errorMessage={} | request={}", e.errorCode, e.errorMessage, message)
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
