package ai.platon.browser4.chrome

import ai.platon.browser4.chrome.protocol.support.EventHandler
import ai.platon.browser4.chrome.protocol.support.EventListener
import ai.platon.browser4.chrome.util.ChromeIOException
import ai.platon.browser4.chrome.util.ChromeServiceException
import ai.platon.browser4.api.model.BrowserTab
import ai.platon.browser4.api.model.ChromeVersion
import ai.platon.browser4.api.model.DevToolsConfig
import ai.platon.browser4.api.model.MethodInvocation
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

interface ChromeService : AutoCloseable {

    val isActive: Boolean

    val version: ChromeVersion

    val host: String

    val port: Int

    fun canConnect(): Boolean

    @Throws(ChromeServiceException::class)
    fun listTabs(): Array<BrowserTab>

    @Throws(ChromeServiceException::class)
    fun createTab(): BrowserTab

    @Throws(ChromeServiceException::class)
    fun createTab(url: String): BrowserTab

    @Throws(ChromeServiceException::class)
    fun activateTab(tab: BrowserTab)

    @Throws(ChromeServiceException::class)
    fun closeTab(tab: BrowserTab)

    @Throws(ChromeServiceException::class)
    fun createDevTools(tab: BrowserTab, config: DevToolsConfig = DevToolsConfig()): BrowserDevTools

    // Compatibility
    @Throws(ChromeServiceException::class)
    fun createDevToolsService(tab: BrowserTab): BrowserDevTools = createDevTools(tab, DevToolsConfig())

    // Compatibility
    @Throws(ChromeServiceException::class)
    fun createDevToolsService(tab: BrowserTab, config: DevToolsConfig = DevToolsConfig()): BrowserDevTools =
        createDevTools(tab, config)
}

/**
 * Minimal DevTools interface for browser4-browser.
 * Replaces ChromeDevToolsService which extended ChromeDevTools from cdt-kotlin-client-serialization.
 */
interface BrowserDevTools : AutoCloseable {

    val isOpen: Boolean

    suspend fun <T : Any> invoke(
        clazz: KClass<T>,
        returnProperty: String?,
        returnTypeClasses: Array<KClass<*>>?,
        method: MethodInvocation
    ): T?

    suspend operator fun <T : Any> invoke(
        method: String,
        params: Map<String, Any?>?,
        returnClass: KClass<T>,
        returnProperty: String? = null
    ): T?

    suspend fun <T : Any> execute(
        method: String,
        params: Map<String, Any?>?,
        returnClass: KClass<T>,
        returnProperty: String? = null
    ): T? = invoke(method, params, returnClass, returnProperty)

    fun awaitTermination()

    fun addEventListener(
        domainName: String,
        eventName: String,
        eventHandler: EventHandler<Any>,
        eventType: KClass<*>
    ): EventListener

    fun removeEventListener(eventListener: EventListener)

    // Compatibility
    fun waitUntilClosed() = awaitTermination()
}

suspend inline operator fun <reified T : Any> BrowserDevTools.invoke(
    method: String, params: Map<String, Any?>?, returnProperty: String? = null
): T? = invoke(method, params, T::class, returnProperty)

// Compatibility
typealias RemoteChrome = ChromeService
typealias RemoteDevTools = BrowserDevTools
typealias ChromeDevToolsService = BrowserDevTools
