package ai.platon.pulsar.browser.driver.chrome

import ai.platon.cdt.kt.protocol.ChromeDevTools
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.pulsar.browser.driver.chrome.util.ChromeIOException
import ai.platon.pulsar.browser.driver.chrome.util.ChromeServiceException
import java.net.URI
import java.util.function.Consumer
import kotlin.reflect.KClass

interface Transport : AutoCloseable {
    val isOpen: Boolean

    @Throws(ChromeIOException::class)
    fun connect(uri: URI)

    @Throws(ChromeIOException::class)
    suspend fun send(message: String)

    fun addMessageHandler(consumer: Consumer<String>)
}

interface RemoteChrome : AutoCloseable {

    val isActive: Boolean

    val version: ChromeVersion

    val host: String

    val port: Int

    fun canConnect(): Boolean

    @Throws(ChromeServiceException::class)
    fun listTabs(): Array<ChromeTab>

    @Throws(ChromeServiceException::class)
    fun createTab(): ChromeTab

    @Throws(ChromeServiceException::class)
    fun createTab(url: String): ChromeTab

    @Throws(ChromeServiceException::class)
    fun activateTab(tab: ChromeTab)

    @Throws(ChromeServiceException::class)
    fun closeTab(tab: ChromeTab)

    @Throws(ChromeServiceException::class)
    fun createDevTools(tab: ChromeTab, config: DevToolsConfig = DevToolsConfig()): RemoteDevTools
}

interface RemoteDevTools : ChromeDevTools, AutoCloseable {

    val isOpen: Boolean

    suspend fun <T> invoke(
        clazz: Class<T>,
        returnProperty: String?,
        returnTypeClasses: Array<Class<out Any>>?,
        method: MethodInvocation
    ): T?

    suspend operator fun <T : Any> invoke(
        method: String,
        params: Map<String, Any?>?,
        returnClass: KClass<T>,
        returnProperty: String? = null
    ): T?

    @Throws(InterruptedException::class)
    fun awaitTermination()

    fun addEventListener(
        domainName: String,
        eventName: String,
        eventHandler: EventHandler<Any>,
        eventType: Class<*>
    ): EventListener

    fun removeEventListener(eventListener: EventListener)
}

suspend inline operator fun <reified T : Any> RemoteDevTools.invoke(
    method: String, params: Map<String, Any?>?, returnProperty: String? = null
): T? = invoke(method, params, T::class, returnProperty)
