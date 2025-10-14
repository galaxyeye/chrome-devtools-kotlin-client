package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.pulsar.browser.driver.chrome.MethodInvocation
import ai.platon.pulsar.browser.driver.chrome.RemoteDevTools
import ai.platon.pulsar.browser.driver.chrome.impl.EventDispatcher.Companion.ID_PROPERTY
import ai.platon.pulsar.browser.driver.chrome.util.ChromeIOException
import ai.platon.pulsar.browser.driver.chrome.util.ChromeRPCException
import ai.platon.pulsar.browser.driver.chrome.util.SuspendAwareHandler
import kotlinx.coroutines.runBlocking
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.util.concurrent.atomic.AtomicLong

class DevToolsInvocationHandler(impl: Any): SuspendAwareHandler(impl) {
    companion object {
        private const val EVENT_LISTENER_PREFIX = "on"
        private val ID_SUPPLIER = AtomicLong(1L)

        fun nextId() = ID_SUPPLIER.incrementAndGet()

        /**
         *
         * */
        fun createMethodInvocation(method: String, params: Map<String, Any?>?): MethodInvocation {
            val params0 = (params ?: emptyMap()).toMutableMap()
            val methodId = params0[ID_PROPERTY]?.toString()?.toLongOrNull() ?: nextId()
            params0[ID_PROPERTY] = methodId.toString()

            val params1 = params0.filterValues { it != null } as Map<String, Any>
            return MethodInvocation(methodId, method, params1)
        }

        fun createMethodInvocation(method: Method, args: Array<out Any>? = null): MethodInvocation {
            val domainName = method.declaringClass.simpleName
            val methodName = method.name
            return MethodInvocation(nextId(), "$domainName.$methodName", buildMethodParams(method, args))
        }

        private fun buildMethodParams(method: Method, args: Array<out Any>? = null): Map<String, Any> {
            val params: MutableMap<String, Any> = HashMap()
            val parameters = method.parameters
            if (args != null) {
                for (i in args.indices) {
                    params[parameters[i].getAnnotation(ParamName::class.java).value] = args[i]
                }
            }
            return params
        }
    }

    lateinit var devTools: RemoteDevTools


    @Throws(ChromeIOException::class, ChromeRPCException::class)
    override fun invoke(target: Any, method: Method, args: Array<out Any>?): Any? {
        if (isEventSubscription(method)) {
            return handleEventSubscription(target, method, args)
        }

        val returnType = method.returnType
        val returnTypeClasses = method.getAnnotation(ReturnTypeParameter::class.java)
                ?.value?.map { it.java }?.toTypedArray()
        val returnProperty = method.getAnnotation(Returns::class.java)?.value

        val methodInvocation = createMethodInvocation(method, args)
        return runBlocking {
            // Invokes a remote method and returns the result.
            devTools.invoke(returnType, returnProperty, returnTypeClasses, methodInvocation)
        }
    }

    private fun handleEventSubscription(target: Any, method: Method, args: Array<out Any>?): EventListener {
        val domainName = method.declaringClass.simpleName
        val eventName: String = getEventName(method)
        val eventHandlerType: Class<*> = getEventHandlerType(method)
        return devTools.addEventListener(domainName, eventName, args!![0] as EventHandler<Any>, eventHandlerType)
    }

    private fun getEventName(method: Method): String {
        return method.getAnnotation(EventName::class.java).value
    }

    private fun getEventHandlerType(method: Method): Class<*> {
        return (method.genericParameterTypes[0] as ParameterizedType).actualTypeArguments[0] as Class<*>
    }

    /**
     * Checks if given method has signature of event subscription.
     *
     * @param method Method to check.
     * @return True if this is event subscription method that is: EventListener on*(EventHandler)
     */
    private fun isEventSubscription(method: Method): Boolean {
        val name = method.name
        val parameters = method.parameters
        return (name.startsWith(EVENT_LISTENER_PREFIX)
                && EventListener::class.java == method.returnType
                && parameters != null
                && parameters.size == 1
                && EventHandler::class.java.isAssignableFrom(parameters[0].type))
    }
}
