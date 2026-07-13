package ai.platon.browser4.chrome.protocol.transport

import ai.platon.browser4.api.model.MethodInvocation
import java.util.concurrent.atomic.AtomicLong

object DevToolsInvocationHandler {
    private val ID_SUPPLIER = AtomicLong(1L)

    private fun nextId() = ID_SUPPLIER.incrementAndGet()

    fun createMethodInvocation(method: String, params: Map<String, Any?>?): MethodInvocation {
        val params0 = (params ?: emptyMap()).toMutableMap()
        val methodId = params0[EventDispatcher.ID_PROPERTY]?.toString()?.toLongOrNull() ?: nextId()
        params0[EventDispatcher.ID_PROPERTY] = methodId.toString()

        val params1: Map<String, Any> = params0.entries
            .filter { it.value != null }
            .associate { it.key to it.value as Any }
        return MethodInvocation(methodId, method, params1)
    }
}
