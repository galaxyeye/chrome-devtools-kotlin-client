@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.support

import kotlin.reflect.KClass

/**
 * Functional interface for CDP event handlers.
 * Mirrors the cdt-kotlin-client-serialization version exactly.
 */
fun interface EventHandler<T> {
    suspend fun onEvent(event: T)
}

/**
 * Listener handle returned when subscribing to CDP events.
 * Mirrors the cdt-kotlin-client-serialization version exactly.
 */
interface EventListener {
    /** Alias to unsubscribe. */
    fun off()

    /** Unsubscribe this event listener. */
    fun unsubscribe()
}

// ── Annotations (mirror cdt-kotlin-client-serialization support.annotations) ──

@Target(AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class Optional

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.CLASS,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class Experimental

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ParamName(val value: String)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class Returns(val value: String)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ReturnTypeParameter(vararg val value: KClass<*>)

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventName(val value: String)
