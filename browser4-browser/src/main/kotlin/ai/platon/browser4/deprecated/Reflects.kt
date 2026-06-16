package ai.platon.browser4.deprecated

import java.lang.reflect.*
import kotlin.coroutines.Continuation
import kotlin.reflect.KVariance

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
        val isSuspend = method.parameterTypes.lastOrNull()?.let { Continuation::class.java.isAssignableFrom(it) } == true

        if (isSuspend) {
            val lastGeneric = method.genericParameterTypes.last()
            if (lastGeneric !is ParameterizedType) return Any::class.java to null

            val returnType = lastGeneric.actualTypeArguments.firstOrNull() ?: return Any::class.java to null
            val (clazz, typeParams) = resolveType(returnType)
            return unboxIfWrapper(clazz) to typeParams
        } else {
            // Non-suspend path — rare in CDP usage, preserved for compatibility
            val rt = method.genericReturnType
            return when (rt) {
                is Class<*> -> unboxIfWrapper(rt) to null
                is ParameterizedType -> {
                    val args = rt.actualTypeArguments
                    val clazz = if (args.isNotEmpty()) rawOf(args[0]) else rawOf(rt.rawType)
                    var typeParams: Array<Class<*>>? = null
                    if (args.isNotEmpty() && args[0] is ParameterizedType) {
                        val inner = args[0] as ParameterizedType
                        val inferred = inner.actualTypeArguments.map { a -> rawOf(a) }.toTypedArray()
                        if (inferred.isNotEmpty()) typeParams = inferred
                    }
                    unboxIfWrapper(clazz) to typeParams
                }
                else -> Any::class.java to null
            }
        }
    }

    /** Extract the raw Class from a [java.lang.reflect.Type], resolving wildcard bounds if present. */
    private fun rawOf(t: java.lang.reflect.Type): Class<*> = when (t) {
        is Class<*> -> t
        is ParameterizedType -> t.rawType as Class<*>
        is WildcardType -> {
            val bound = t.lowerBounds.firstOrNull() ?: t.upperBounds.firstOrNull()
            when (bound) {
                is Class<*> -> bound
                is ParameterizedType -> bound.rawType as Class<*>
                else -> Any::class.java
            }
        }
        else -> Any::class.java
    }

    /** Resolve a [java.lang.reflect.Type] into (rawClass, typeParameters). */
    private fun resolveType(type: java.lang.reflect.Type): Pair<Class<*>, Array<Class<*>>?> {
        return when (type) {
            is Class<*> -> type to null
            is ParameterizedType -> {
                val typeParams = type.actualTypeArguments.map { rawOf(it) }.toTypedArray()
                val params = if (typeParams.isNotEmpty()) typeParams else null
                (type.rawType as Class<*>) to params
            }
            is WildcardType -> {
                val bound = type.lowerBounds.firstOrNull() ?: type.upperBounds.firstOrNull()
                when (bound) {
                    is ParameterizedType -> {
                        val typeParams = bound.actualTypeArguments.map { rawOf(it) }.toTypedArray()
                        val params = if (typeParams.isNotEmpty()) typeParams else null
                        (bound.rawType as Class<*>) to params
                    }
                    is Class<*> -> bound to null
                    else -> Any::class.java to null
                }
            }
            else -> Any::class.java to null
        }
    }
}
