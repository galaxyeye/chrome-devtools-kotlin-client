package ai.platon.browser4.integration

import ai.platon.cdt.kt.serialization.protocol.types.page.CaptureScreenshotFormat
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.Base64

class ChromeIntegrationTest : BrowserIntegrationTest() {

    @Test
    @DisplayName("launch Chrome, navigate, evaluate JS, and capture screenshot")
    fun testLaunchNavigateEvaluateScreenshot() = runBlocking {
        // 1. Verify Chrome is alive
        assertTrue(bp.isOpen, "CDP connection should be open")
        assertTrue(bp.isTargetAlive(), "Target should be alive")

        // 2. Navigate to local test page
        val navigateUrl = "$baseUrl/simple.html"
        val navResult = bp.navigate(navigateUrl)
        assertNotNull(navResult, "Navigation result should not be null")
        assertNotNull(navResult.frameId, "Frame ID should be set")

        // 3. Verify page loaded by evaluating JS
        val titleEval = bp.evaluate("document.title", returnByValue = true)
        assertEquals("Test Page", titleEval.result?.value, "Page title should be 'Test Page'")

        // 4. Verify DOM is accessible
        val headingEval = bp.evaluate(
            "document.getElementById('main-heading').textContent",
            returnByValue = true
        )
        assertEquals("Hello World", headingEval.result?.value)

        // 5. Take a screenshot and verify it's a valid image
        val screenshot = bp.captureScreenshot(format = CaptureScreenshotFormat.PNG)
        assertNotNull(screenshot, "Screenshot should not be null")
        assertTrue(screenshot.isNotBlank(), "Screenshot base64 should not be blank")

        // Verify PNG header bytes
        val imageBytes = Base64.getDecoder().decode(screenshot)
        assertTrue(imageBytes.size > 100, "Screenshot should be at least 100 bytes")
        assertEquals(0x89.toByte(), imageBytes[0], "PNG magic byte 0")
        assertEquals('P'.code.toByte(), imageBytes[1], "PNG magic byte 1")
    }

    @Test
    @DisplayName("navigate to external page works")
    fun testNavigateToExternalPage() = runBlocking {
        val navResult = bp.navigate("https://example.com/")
        assertNotNull(navResult)

        val title = bp.evaluate("document.title", returnByValue = true)
        assertEquals("Example Domain", title.result?.value)
    }

    @Test
    @DisplayName("layout metrics return valid viewport")
    fun testLayoutMetrics() = runBlocking {
        bp.navigate("$baseUrl/long-page.html")

        val metrics = bp.getLayoutMetrics()
        assertNotNull(metrics)
        assertTrue(metrics.layoutViewport.clientWidth > 0)
        assertTrue(metrics.layoutViewport.clientHeight > 0)
    }
}
