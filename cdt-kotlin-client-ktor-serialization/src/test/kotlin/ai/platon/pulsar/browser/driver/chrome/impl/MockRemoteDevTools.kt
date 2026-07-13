package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.pulsar.browser.driver.chrome.ChromeDevToolsService
import ai.platon.pulsar.browser.driver.chrome.MethodInvocation
import kotlin.reflect.KClass

/**
 * Mock implementation of [ChromeDevToolsService] for testing [DirectChromeProtocol].
 *
 * Tracks all method invocations and event listener registrations. Test code can
 * pre-configure responses for specific CDP methods via [respond] and trigger
 * simulated CDP events via [fireEvent].
 */
class MockRemoteDevTools : ChromeDevToolsService {

    override var isOpen: Boolean = true

    /** Records of every invocation received by the mock. */
    data class InvocationRecord(
        val method: String,
        val params: Map<String, Any?>?,
        val returnClass: Class<*>?,
        val returnProperty: String?,
        val returnTypeClasses: Array<Class<out Any>>?,
    )

    private val _invocations = mutableListOf<InvocationRecord>()
    val invocations: List<InvocationRecord> get() = _invocations.toList()

    /** Pre-configured responses keyed by CDP method name. */
    private val responses = mutableMapOf<String, (Map<String, Any?>?) -> Any?>()

    /** Pre-configured list responses. */
    private val listResponses = mutableMapOf<String, (Map<String, Any?>?) -> List<*>>()

    /** Pre-configured nested-list responses. */
    private val nestedListResponses = mutableMapOf<String, (Map<String, Any?>?) -> List<List<*>>>()

    // ---- Event listener storage ----

    data class EventListenerRecord(
        val domainName: String,
        val eventName: String,
        val eventHandler: EventHandler<Any>,
        val eventType: Class<*>,
    )

    private val _eventListeners = mutableListOf<EventListenerRecord>()
    val eventListeners: List<EventListenerRecord> get() = _eventListeners.toList()

    private val registeredListeners = mutableListOf<MockEventListener>()

    inner class MockEventListener(
        val key: String,
        val handler: EventHandler<Any>,
        val type: Class<*>,
    ) : EventListener {
        override fun off() = unsubscribe()
        override fun unsubscribe() {
            registeredListeners.remove(this)
            _eventListeners.removeAll { it.eventHandler == handler }
        }
    }

    // ---- Response configuration ----

    /** Register a response for a CDP method name. The lambda receives the params map. */
    fun respond(method: String, handler: (Map<String, Any?>?) -> Any?) {
        responses[method] = handler
    }

    /** Register a list response for a CDP method. */
    fun respondList(method: String, handler: (Map<String, Any?>?) -> List<*>) {
        listResponses[method] = handler
    }

    /** Register a nested-list response for a CDP method. */
    fun respondNestedList(method: String, handler: (Map<String, Any?>?) -> List<List<*>>) {
        nestedListResponses[method] = handler
    }

    /** Clear all recorded invocations (useful between test cases). */
    fun resetInvocations() {
        _invocations.clear()
    }

    /** Clear all registered event listeners. */
    fun resetEventListeners() {
        registeredListeners.clear()
        _eventListeners.clear()
    }

    /** Reset everything. */
    fun reset() {
        responses.clear()
        listResponses.clear()
        nestedListResponses.clear()
        resetInvocations()
        resetEventListeners()
        isOpen = true
    }

    // ---- Simulate incoming CDP events ----

    /**
     * Fire a simulated CDP event to all registered listeners whose key matches
     * "domainName.eventName".
     */
    @Suppress("UNCHECKED_CAST")
    suspend fun fireEvent(domainName: String, eventName: String, event: Any) {
        val key = "$domainName.$eventName"
        for (listener in _eventListeners) {
            if (listener.domainName == domainName && listener.eventName == eventName) {
                listener.eventHandler.onEvent(event)
            }
        }
    }

    // ---- ChromeDevToolsService implementation ----

    override suspend fun <T> invoke(
        clazz: Class<T>,
        returnProperty: String?,
        returnTypeClasses: Array<Class<out Any>>?,
        method: MethodInvocation,
    ): T? {
        _invocations.add(
            InvocationRecord(
                method = method.method,
                params = method.params,
                returnClass = clazz,
                returnProperty = returnProperty,
                returnTypeClasses = returnTypeClasses,
            )
        )

        // Check list/nested-list responses first (used by listCommand/nestedListCommand)
        if (returnTypeClasses != null && returnTypeClasses.isNotEmpty()) {
            val innerClass = returnTypeClasses.last()
            if (innerClass == Double::class.java) {
                @Suppress("UNCHECKED_CAST")
                return nestedListResponses[method.method]?.invoke(method.params) as T?
            }
            @Suppress("UNCHECKED_CAST")
            return listResponses[method.method]?.invoke(method.params) as T?
        }

        @Suppress("UNCHECKED_CAST")
        return responses[method.method]?.invoke(method.params) as T?
    }

    @Suppress("UNCHECKED_CAST")
    override suspend fun <T : Any> invoke(
        method: String,
        params: Map<String, Any?>?,
        returnClass: KClass<T>,
        returnProperty: String?,
    ): T? {
        _invocations.add(
            InvocationRecord(
                method = method,
                params = params,
                returnClass = returnClass.java,
                returnProperty = returnProperty,
                returnTypeClasses = null,
            )
        )

        return responses[method]?.invoke(params) as T?
    }

    override fun awaitTermination() {
        // No-op in mock
    }

    override fun addEventListener(
        domainName: String,
        eventName: String,
        eventHandler: EventHandler<Any>,
        eventType: Class<*>,
    ): EventListener {
        val record = EventListenerRecord(domainName, eventName, eventHandler, eventType)
        _eventListeners.add(record)
        val listener = MockEventListener("$domainName.$eventName", eventHandler, eventType)
        registeredListeners.add(listener)
        return listener
    }

    override fun removeEventListener(eventListener: EventListener) {
        if (eventListener is MockEventListener) {
            registeredListeners.remove(eventListener)
            _eventListeners.removeAll { it.eventHandler == eventListener.handler }
        }
    }

    override fun close() {
        isOpen = false
        // Note: we do NOT call reset() here because tests may want to verify
        // state after close. close() only sets isOpen = false.
        registeredListeners.clear()
        _eventListeners.clear()
    }
}
