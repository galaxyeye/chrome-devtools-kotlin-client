package ai.platon.browser4.chrome.protocol

import ai.platon.browser4.api.BrowserProtocol
import ai.platon.browser4.api.model.Locator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class DOMHandlerTest {

    private val mockProtocol = mock<BrowserProtocol>()
    private val handler = DOMHandler(mockProtocol)

    @Test
    @DisplayName("normalizeSelector returns CSS selector for CSS input")
    fun normalizeSelectorReturnsCssForCssInput() {
        val selector = handler.normalizeSelector("div.my-class")
        assertEquals("div.my-class", selector)
    }

    @Test
    @DisplayName("normalizeSelector returns CSS selector for ID input")
    fun normalizeSelectorReturnsCssForIdInput() {
        val selector = handler.normalizeSelector("#main-content")
        assertEquals("#main-content", selector)
    }

    @Test
    @DisplayName("normalizeSelector returns empty string for empty input")
    fun normalizeSelectorReturnsEmptyForEmptyInput() {
        val selector = handler.normalizeSelector("")
        assertEquals("", selector)
    }

    @Test
    @DisplayName("normalizeLocator returns Locator with CSS selector for CSS input")
    fun normalizeLocatorReturnsCssForCssInput() {
        val result = handler.normalizeLocator("div.container")
        assertNotNull(result)
        assertEquals("div.container", result!!.cssSelector)
        assertEquals(Locator.Type.CSS_PATH, result.locator.type)
    }

    @Test
    @DisplayName("normalizeLocator returns Locator with null CSS selector for XPath input")
    fun normalizeLocatorReturnsNullCssForXPath() {
        val result = handler.normalizeLocator("//div[@class='container']")
        assertNotNull(result)
        assertNull(result!!.cssSelector)
        assertEquals(Locator.Type.XPATH, result.locator.type)
    }

    @Test
    @DisplayName("normalizeLocator returns non-null for empty locator")
    fun normalizeLocatorReturnsForEmptyLocator() {
        val result = handler.normalizeLocator("")
        assertNotNull(result)
        assertEquals("", result!!.cssSelector)
    }

    @Test
    @DisplayName("normalizeLocator returns Locator for backend node ID")
    fun normalizeLocatorReturnsForBackendNodeId() {
        val result = handler.normalizeLocator("e12345")
        assertNotNull(result)
        assertEquals(Locator.Type.BACKEND_NODE_ID, result!!.locator.type)
        assertEquals("12345", result.locator.selector)
    }

    @Test
    @DisplayName("normalizeLocator with jsEscape wraps CSS selector in safe string")
    fun normalizeLocatorWithJsEscape() {
        val result = handler.normalizeLocator("div.test", jsEscape = true)
        assertNotNull(result)
        assertTrue(result!!.cssSelector!!.contains("div.test"))
    }

    @Test
    @DisplayName("normalizeLocator handles complex CSS selector")
    fun normalizeLocatorHandlesComplexCss() {
        val result = handler.normalizeLocator("ul.menu > li.active a[href]")
        assertNotNull(result)
        assertEquals("ul.menu > li.active a[href]", result!!.cssSelector)
    }

    @Test
    @DisplayName("normalizeLocator handles FBN locator format")
    fun normalizeLocatorHandlesFbnFormat() {
        // Frame Backend Node ID format: "fbn:FRAME_ID,123"
        val result = handler.normalizeLocator("fbn:main,42")
        assertNotNull(result)
        assertEquals(Locator.Type.FRAME_BACKEND_NODE_ID, result!!.locator.type)
    }
}
