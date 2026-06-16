package ai.platon.browser4.integration

import ai.platon.browser4.chrome.protocol.JsHandler
import ai.platon.browser4.chrome.protocol.PageHandler
import ai.platon.browser4.chrome.IsolatedWorldManager
import ai.platon.browser4.api.model.BrowserSettings
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class JsHandlerIntegrationTest : BrowserIntegrationTest() {

    private lateinit var jsHandler: JsHandler
    private lateinit var pageHandler: PageHandler

    @BeforeEach
    fun setupHandlers() {
        pageHandler = PageHandler(bp, BrowserSettings())
        val isolatedWorldManager = IsolatedWorldManager(bp, BrowserSettings())
        jsHandler = JsHandler(bp, pageHandler, isolatedWorldManager)
    }

    @Test
    @DisplayName("evaluate simple arithmetic expression")
    fun testEvaluateArithmetic() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val result = jsHandler.evaluate("1 + 1")
        assertEquals(2, result, "1 + 1 should equal 2")
    }

    @Test
    @DisplayName("evaluate returns page title")
    fun testEvaluatePageTitle() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val result = jsHandler.evaluate("document.title")
        assertEquals("Test Page", result)
    }

    @Test
    @DisplayName("evaluateValue returns structured result")
    fun testEvaluateValue() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val result = jsHandler.evaluateValue("document.getElementById('name').placeholder")
        assertEquals("Enter your name", result)
    }

    @Test
    @DisplayName("evaluate on selector returns element property")
    fun testEvaluateValueOnSelector() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val result = jsHandler.evaluateValue("#name", "function() { return this.tagName; }")
        assertEquals("INPUT", result)
    }

    @Test
    @DisplayName("evaluate document.URL after navigation")
    fun testEvaluateDocumentURL() = runBlocking {
        val url = "$baseUrl/simple.html"
        pageHandler.navigate(url)

        val result = jsHandler.evaluate("document.URL") as String
        assertTrue(result.contains("simple.html"), "URL should contain simple.html")
    }

    @Test
    @DisplayName("evaluateDetail returns full CDP response")
    fun testEvaluateDetail() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val detail = jsHandler.evaluateDetail("42")
        assertNotNull(detail, "Evaluate detail should not be null")
        assertNotNull(detail!!.result, "Result should not be null")
        assertNull(detail.exceptionDetails, "No exception expected")
    }
}
