package ai.platon.browser4.integration

import ai.platon.browser4.chrome.protocol.PageHandler
import ai.platon.browser4.api.model.BrowserSettings
import ai.platon.browser4.api.model.Locator
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PageHandlerIntegrationTest : BrowserIntegrationTest() {

    private lateinit var pageHandler: PageHandler

    @BeforeEach
    fun setupPageHandler() {
        pageHandler = PageHandler(bp, BrowserSettings())
    }

    @Test
    @DisplayName("navigate to local page and verify DOM attributes")
    fun testNavigateAndGetAttribute() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val id = pageHandler.getAttribute("h1", "id")
        assertEquals("main-heading", id)
    }

    @Test
    @DisplayName("navigate to form page and verify form elements")
    fun testFormPageElements() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val placeholder = pageHandler.getAttribute("#name", "placeholder")
        assertEquals("Enter your name", placeholder)

        val exists = pageHandler.exists("#submit-btn")
        assertTrue(exists, "Submit button should exist")
    }

    @Test
    @DisplayName("check element visibility")
    fun testElementVisibility() = runBlocking {
        bp.cssEnable()
        pageHandler.navigate("$baseUrl/simple.html")

        val visible = pageHandler.isVisible("h1")
        assertTrue(visible, "h1 should be visible")
    }

    @Test
    @DisplayName("ariaSnapshot returns non-empty YAML")
    fun testAriaSnapshot() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val snapshot = pageHandler.ariaSnapshot()
        assertNotNull(snapshot)
        assertTrue(snapshot.isNotBlank(), "ARIA snapshot should not be blank")
        // Should contain page structure info
        assertTrue(snapshot.contains("heading") || snapshot.contains("StaticText"),
            "ARIA snapshot should contain accessibility nodes")
    }

    @Test
    @DisplayName("focus on selector returns valid NodeRef")
    fun testFocusOnSelector() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        val nodeRef = pageHandler.focusOnSelector("#name")
        assertNotNull(nodeRef, "Should return a NodeRef")
        assertTrue(nodeRef!!.nodeId > 0, "Node ID should be positive")
    }

    @Test
    @DisplayName("isChecked works for checkbox")
    fun testIsChecked() = runBlocking {
        pageHandler.navigate("$baseUrl/form.html")

        // Initially unchecked
        val checked = pageHandler.isChecked("#agree")
        assertFalse(checked, "Checkbox should be unchecked by default")
    }
}
