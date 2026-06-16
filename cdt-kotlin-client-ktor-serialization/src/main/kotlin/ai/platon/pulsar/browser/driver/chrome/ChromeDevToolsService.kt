package ai.platon.pulsar.browser.driver.chrome

import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import kotlin.reflect.KClass

interface ChromeDevToolsService : AutoCloseable {

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
        eventType: Class<*>
    ): EventListener

    fun removeEventListener(eventListener: EventListener)

    // Compatibility
    fun waitUntilClosed() = awaitTermination()
}

suspend inline operator fun <reified T : Any> RemoteDevTools.invoke(
    method: String, params: Map<String, Any?>?, returnProperty: String? = null
): T? = invoke(method, params, T::class, returnProperty)

// Compatibility aliases
typealias RemoteChrome = ChromeService
typealias RemoteDevTools = ChromeDevToolsService
