package ai.platon.pulsar.deprecated.util

import kotlinx.coroutines.*
import java.lang.reflect.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.resume
import kotlin.reflect.KVariance
import kotlin.reflect.full.callSuspend
import kotlin.reflect.full.declaredFunctions

open class SuspendAwareHandler(private val impl: Any) : InvocationHandler {
    private val eventHandlerScope = CoroutineScope(SupervisorJob() + Dispatchers.Default + CoroutineName("CDTHandler"))

    @Suppress("UNCHECKED_CAST")
    override fun invoke(proxy: Any, method: Method, args: Array<out Any>?): Any? {
        val kFunc = impl::class.declaredFunctions.find { it.name == method.name } ?: return null
        val realArgs = args ?: emptyArray()

        // 检查是否是 suspend 函数
        return if (kFunc.isSuspend) {
            val cont = realArgs.last() as Continuation<Any?>
            eventHandlerScope.launch(cont.context) {
                val result = kFunc.callSuspend(impl, *realArgs.dropLast(1).toTypedArray())
                cont.resume(result)
            }
            COROUTINE_SUSPENDED
        } else {
            kFunc.call(impl, *realArgs)
        }
    }
}

/**
 * TODO: will remove reflection approach in the future, as it is too fragile and hard to maintain. The main reason for
 *  using reflection here is to simplify CDP programming, but in AI era, it is simper to send raw JSON commands to CDP.
 * */
object ReflectUtils {

    fun getJavaClass(method: Method): Class<*> {
        val pType = method.genericParameterTypes[0] as ParameterizedType
        val raw = pType.rawType as Class<*>
        val type = pType.actualTypeArguments[0]
        return when (type) {
            is Class<*> -> {
                // In Kotlin, declaration-site variance (out T) is compiled to use-site wildcards in Java.
                // However, depending on compilation details, we might see a concrete Class here.
                // If the raw type's first type parameter is covariant (OUT) and there's no lower bound,
                // we should conservatively return Any.
                val kParams = raw.kotlin.typeParameters
                val isOut = kParams.firstOrNull()?.variance == KVariance.OUT
                if (isOut) Any::class.java else type
            }
            is ParameterizedType -> type.rawType as Class<*>
            is WildcardType -> {
                val lowerBounds = type.lowerBounds
                if (lowerBounds.isNotEmpty()) {
                    when (val lb = lowerBounds[0]) {
                        is Class<*> -> lb
                        is ParameterizedType -> lb.rawType as Class<*>
                        else -> Any::class.java
                    }
                } else {
                    Any::class.java
                }
            }
            else -> Any::class.java
        }
    }

    private fun unboxIfWrapper(c: Class<*>): Class<*> = when (c) {
        Integer::class.java -> Int::class.javaPrimitiveType!!
        java.lang.Long::class.java -> Long::class.javaPrimitiveType!!
        java.lang.Boolean::class.java -> Boolean::class.javaPrimitiveType!!
        java.lang.Short::class.java -> Short::class.javaPrimitiveType!!
        java.lang.Byte::class.java -> Byte::class.javaPrimitiveType!!
        Character::class.java -> Char::class.javaPrimitiveType!!
        java.lang.Float::class.java -> Float::class.javaPrimitiveType!!
        java.lang.Double::class.java -> Double::class.javaPrimitiveType!!
        else -> c
    }

    /**
     * Resolve an accurate return type for the given method. For suspend functions, the JVM signature
     * returns `Object` and the actual type is stored in the Continuation's generic argument.
     */
    fun resolveReturnType(method: Method): Pair<Class<*>, Array<Class<*>>?> {
        var typeParams: Array<Class<*>>? = null

        fun classFromType(t: Type): Class<*> = when (t) {
            is Class<*> -> t
            is ParameterizedType -> t.rawType as Class<*>
            is WildcardType -> {
                val lb = t.lowerBounds.firstOrNull()
                val ub = t.upperBounds.firstOrNull()
                when (lb) {
                    is Class<*> -> lb
                    is ParameterizedType -> lb.rawType as Class<*>
                    else -> when (ub) {
                        is Class<*> -> ub
                        is ParameterizedType -> ub.rawType as Class<*>
                        else -> Any::class.java
                    }
                }
            }
            else -> Any::class.java
        }

        val isSuspend = method.parameterTypes.lastOrNull()?.let { Continuation::class.java.isAssignableFrom(it) } == true
        if (isSuspend) {
            val lastGeneric = method.genericParameterTypes.last()
            if (lastGeneric is ParameterizedType) {
                val t = lastGeneric.actualTypeArguments.firstOrNull()
                if (t != null) {
                    val clazz = when (t) {
                        is Class<*> -> t
                        is ParameterizedType -> {
                            val rawType = t.rawType as Class<*>
                            val inferred = t.actualTypeArguments.map { arg -> classFromType(arg) }.toTypedArray()
                            if (inferred.isNotEmpty()) typeParams = inferred
                            rawType
                        }
                        is WildcardType -> {
                            val bound = t.lowerBounds.firstOrNull() ?: t.upperBounds.firstOrNull()
                            when (bound) {
                                is ParameterizedType -> {
                                    val rawType = bound.rawType as Class<*>
                                    val inferred = bound.actualTypeArguments.map { arg -> classFromType(arg) }.toTypedArray()
                                    if (inferred.isNotEmpty()) typeParams = inferred
                                    rawType
                                }
                                is Class<*> -> bound
                                else -> classFromType(t)
                            }
                        }
                        else -> Any::class.java
                    }
                    return unboxIfWrapper(clazz) to typeParams
                }
            }
            return Any::class.java to null
        } else {
            val rt = method.genericReturnType
            return when (rt) {
                is Class<*> -> unboxIfWrapper(rt) to null
                is ParameterizedType -> {
                    val args = rt.actualTypeArguments
                    val clazz = if (args.isNotEmpty()) classFromType(args[0]) else classFromType(rt.rawType)
                    if (args.isNotEmpty() && args[0] is ParameterizedType) {
                        val inner = args[0] as ParameterizedType
                        val inferred = inner.actualTypeArguments.map { a -> classFromType(a) }.toTypedArray()
                        if (inferred.isNotEmpty()) typeParams = inferred
                    }
                    unboxIfWrapper(clazz) to typeParams
                }
                else -> Any::class.java to null
            }
        }
    }
}
