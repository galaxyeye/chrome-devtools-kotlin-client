package ai.platon.pulsar.browser.driver.chrome.util

import org.easymock.EasyMock.mock
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.coroutines.Continuation

class ReflectUtilsTest {

    @Test
    fun resolveReturnType_shouldReturnCorrectTypeForNonSuspendMethod() {
        val method = SampleClass::class.java.getMethod("nonSuspendMethod")
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(String::class.java, clazz)
        assertNull(typeParams)
    }

    @Test
    fun resolveReturnType_shouldReturnCorrectTypeForSuspendMethod() {
        val method = SampleClass::class.java.getMethod("suspendMethod", Continuation::class.java)
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(Int::class.java, clazz)
        assertNull(typeParams)
    }

    @Test
    fun resolveReturnType_shouldHandleWildcardType() {
        val method = SampleClass::class.java.getMethod("wildcardMethod")
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(Any::class.java, clazz)
        assertNull(typeParams)
    }

    @Test
    fun resolveReturnType_nonSuspend_listOfString_returnsElementType() {
        val method = SampleClass::class.java.getMethod("listOfString")
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        // For non-suspend parameterized return, we return the element type
        assertEquals(String::class.java, clazz)
        assertNull(typeParams)
    }

    @Test
    fun resolveReturnType_nonSuspend_listOfListOfString_returnsRawAndTypeParams() {
        val method = SampleClass::class.java.getMethod("listOfListString")
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(List::class.java, clazz)
        assertArrayEquals(arrayOf(String::class.java), typeParams)
    }

    @Test
    fun resolveReturnType_suspend_listOfString_returnsRawAndTypeParams() {
        val method = SampleClass::class.java.getMethod("suspendListOfString", Continuation::class.java)
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(List::class.java, clazz)
        assertArrayEquals(arrayOf(String::class.java), typeParams)
    }

    @Test
    fun resolveReturnType_suspend_listOfListOfString_returnsRawAndShallowTypeParams() {
        val method = SampleClass::class.java.getMethod("suspendListOfListOfString", Continuation::class.java)
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(List::class.java, clazz)
        // Shallow inference: inner parameterized type becomes its raw type
        assertArrayEquals(arrayOf(List::class.java), typeParams)
    }

    @Test
    fun resolveReturnType_nonSuspend_primitiveInt_unboxed() {
        val method = SampleClass::class.java.getMethod("primitiveInt")
        val (clazz, _) = ReflectUtils.resolveReturnType(method)

        // Expect primitive int
        assertEquals(Int::class.java, clazz)
    }

    @Test
    fun getJavaClass_inWildcard_returnsLowerBound() {
        val method = MethodsForGetJavaClass::class.java.getMethod(
            "handlerInString", SimpleInHandler::class.java
        )
        val clazz = ReflectUtils.getJavaClass(method)

        assertEquals(String::class.java, clazz)
    }

    @Test
    fun getJavaClass_outWildcard_returnsAnyWhenNoLowerBound() {
        val method = MethodsForGetJavaClass::class.java.getMethod(
            "handlerOutString", SimpleOutHandler::class.java
        )
        val clazz = ReflectUtils.getJavaClass(method)

        assertEquals(Any::class.java, clazz)
    }

    @Test
    fun getJavaClass_parameterizedActualType_returnsRawType() {
        val method = MethodsForGetJavaClass::class.java.getMethod(
            "handlerInListString", SimpleInHandler::class.java
        )
        val clazz = ReflectUtils.getJavaClass(method)

        assertEquals(List::class.java, clazz)
    }

    @Test
    fun resolveReturnType_suspend_unit_returnsUnitClass() {
        val method = SampleClass::class.java.getMethod("suspendUnit", Continuation::class.java)
        val (clazz, typeParams) = ReflectUtils.resolveReturnType(method)

        assertEquals(Unit::class.java, clazz)
        assertNull(typeParams)
    }
}

interface SimpleInHandler<in T>
interface SimpleOutHandler<out T>

class MethodsForGetJavaClass {
    fun handlerInString(h: SimpleInHandler<String>) {}
    fun handlerOutString(h: SimpleOutHandler<String>) {}
    fun handlerInListString(h: SimpleInHandler<List<String>>) {}
}

interface SampleInterface {
    fun sampleMethod(input: String)
}

abstract class SampleAbstractClass {
    abstract fun abstractMethod()
}

class SampleClass {
    fun nonSuspendMethod(): String = "test"
    suspend fun suspendMethod(): Int = 42
    fun wildcardMethod(): List<*> = listOf("test")

    fun listOfString(): List<String> = listOf("a")
    fun listOfListString(): List<List<String>> = listOf(listOf("a"))
    suspend fun suspendListOfString(): List<String> = listOf("a")
    suspend fun suspendListOfListOfString(): List<List<String>> = listOf(listOf("a"))

    fun primitiveInt(): Int = 1
    suspend fun suspendUnit(): Unit { /* no-op */ }
}
