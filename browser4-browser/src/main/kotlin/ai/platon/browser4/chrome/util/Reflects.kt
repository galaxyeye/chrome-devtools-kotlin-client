package ai.platon.browser4.chrome.util

import java.lang.reflect.*
import kotlin.coroutines.Continuation
import kotlin.reflect.KClass
import kotlin.reflect.KVariance

object ReflectUtils {

    fun getEventKClass(method: Method): KClass<*> {
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
                if (isOut) Any::class else type.kotlin
            }
            is ParameterizedType -> (type.rawType as Class<*>).kotlin
            is WildcardType -> {
                val lowerBounds = type.lowerBounds
                if (lowerBounds.isNotEmpty()) {
                    when (val lb = lowerBounds[0]) {
                        is Class<*> -> lb.kotlin
                        is ParameterizedType -> (lb.rawType as Class<*>).kotlin
                        else -> Any::class
                    }
                } else {
                    Any::class
                }
            }
            else -> Any::class
        }
    }

    private fun unboxIfWrapper(c: KClass<*>): KClass<*> = when (c) {
        java.lang.Integer::class -> Int::class
        java.lang.Long::class -> Long::class
        java.lang.Boolean::class -> Boolean::class
        java.lang.Short::class -> Short::class
        java.lang.Byte::class -> Byte::class
        java.lang.Character::class -> Char::class
        java.lang.Float::class -> Float::class
        java.lang.Double::class -> Double::class
        else -> c
    }

    /**
     * Resolve an accurate return type for the given method. For suspend functions, the JVM signature
     * returns `Object` and the actual type is stored in the Continuation's generic argument.
     */
    fun resolveReturnType(method: Method): Pair<KClass<*>, Array<KClass<*>>?> {
        val isSuspend = method.parameterTypes.lastOrNull()?.let { Continuation::class.java.isAssignableFrom(it) } == true

        if (isSuspend) {
            val lastGeneric = method.genericParameterTypes.last()
            if (lastGeneric !is ParameterizedType) return Any::class to null

            val returnType = lastGeneric.actualTypeArguments.firstOrNull() ?: return Any::class to null
            val (clazz, typeParams) = resolveType(returnType)
            return unboxIfWrapper(clazz) to typeParams
        } else {
            // Non-suspend path — rare in CDP usage, preserved for compatibility
            val rt = method.genericReturnType
            return when (rt) {
                is Class<*> -> unboxIfWrapper(rt.kotlin) to null
                is ParameterizedType -> {
                    val args = rt.actualTypeArguments
                    val clazz = if (args.isNotEmpty()) rawOf(args[0]) else rawOf(rt.rawType)
                    var typeParams: Array<KClass<*>>? = null
                    if (args.isNotEmpty() && args[0] is ParameterizedType) {
                        val inner = args[0] as ParameterizedType
                        val inferred = inner.actualTypeArguments.map { a -> rawOf(a) }.toTypedArray()
                        if (inferred.isNotEmpty()) typeParams = inferred
                    }
                    unboxIfWrapper(clazz) to typeParams
                }
                else -> Any::class to null
            }
        }
    }

    /** Extract the raw [KClass] from a [Type], resolving wildcard bounds if present. */
    private fun rawOf(t: Type): KClass<*> = when (t) {
        is Class<*> -> t.kotlin
        is ParameterizedType -> (t.rawType as Class<*>).kotlin
        is WildcardType -> {
            val bound = t.lowerBounds.firstOrNull() ?: t.upperBounds.firstOrNull()
            when (bound) {
                is Class<*> -> bound.kotlin
                is ParameterizedType -> (bound.rawType as Class<*>).kotlin
                else -> Any::class
            }
        }
        else -> Any::class
    }

    /** Resolve a [Type] into (rawClass, typeParameters). */
    private fun resolveType(type: Type): Pair<KClass<*>, Array<KClass<*>>?> {
        return when (type) {
            is Class<*> -> type.kotlin to null
            is ParameterizedType -> {
                val typeParams = type.actualTypeArguments.map { rawOf(it) }.toTypedArray()
                val params = if (typeParams.isNotEmpty()) typeParams else null
                (type.rawType as Class<*>).kotlin to params
            }
            is WildcardType -> {
                val bound = type.lowerBounds.firstOrNull() ?: type.upperBounds.firstOrNull()
                when (bound) {
                    is ParameterizedType -> {
                        val typeParams = bound.actualTypeArguments.map { rawOf(it) }.toTypedArray()
                        val params = if (typeParams.isNotEmpty()) typeParams else null
                        (bound.rawType as Class<*>).kotlin to params
                    }
                    is Class<*> -> bound.kotlin to null
                    else -> Any::class to null
                }
            }
            else -> Any::class to null
        }
    }
}
