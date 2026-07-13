package ai.platon.browser4.integration

import ai.platon.browser4.chrome.protocol.PageHandler
import ai.platon.browser4.chrome.protocol.ScreenshotHandler
import ai.platon.browser4.api.model.BrowserSettings
import ai.platon.browser4.api.model.NodeRef
import ai.platon.pulsar.common.math.geometric.RectD
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.Base64
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

class ScreenshotHandlerIntegrationTest : BrowserIntegrationTest() {

    private lateinit var screenshotHandler: ScreenshotHandler
    private lateinit var pageHandler: PageHandler

    @BeforeEach
    fun setupHandlers() {
        pageHandler = PageHandler(bp, BrowserSettings())
        screenshotHandler = ScreenshotHandler(pageHandler, bp)
    }

    @Test
    @DisplayName("viewport screenshot produces valid PNG")
    fun testViewportScreenshot() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val screenshot = screenshotHandler.screenshot(fullPage = false)
        assertNotNull(screenshot, "Screenshot should not be null")
        assertTrue(screenshot!!.isNotBlank())
        val bytes = Base64.getDecoder().decode(screenshot)
        assertTrue(bytes.size > 100)
    }

    @Test
    @DisplayName("full page screenshot produces valid PNG")
    fun testFullPageScreenshot() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val screenshot = screenshotHandler.screenshot(fullPage = true)
        assertNotNull(screenshot, "Full page screenshot should not be null")
        val bytes = Base64.getDecoder().decode(screenshot)
        assertTrue(bytes.size > 100)
    }

    @Test
    @DisplayName("element screenshot produces valid PNG")
    fun testElementScreenshot() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")

        val screenshot = screenshotHandler.screenshot("h1")
        assertNotNull(screenshot, "Element screenshot should not be null")
        val bytes = Base64.getDecoder().decode(screenshot)
        assertTrue(bytes.size > 100)
    }

    @Test
    @DisplayName("rect screenshot produces valid PNG")
    fun testRectScreenshot() = runBlocking {
        pageHandler.navigate("$baseUrl/simple.html")
        delay(500.milliseconds) // Wait for page to fully render

        val clip = RectD(0.0, 0.0, 100.0, 100.0)
        val screenshot = screenshotHandler.screenshot(clip)
        assertNotNull(screenshot, "Rect screenshot should not be null")
        val bytes = Base64.getDecoder().decode(screenshot)
        assertTrue(bytes.size > 100)
    }

    @Test
    @DisplayName("full page screenshot of long page is larger than viewport")
    fun testFullPageLongPageIsLarger() = runBlocking {
        pageHandler.navigate("$baseUrl/long-page.html")

        val viewportScreenshot = screenshotHandler.screenshot(fullPage = false)
        val fullPageScreenshot = screenshotHandler.screenshot(fullPage = true)

        assertNotNull(viewportScreenshot)
        assertNotNull(fullPageScreenshot)

        val viewportBytes = Base64.getDecoder().decode(viewportScreenshot).size
        val fullPageBytes = Base64.getDecoder().decode(fullPageScreenshot).size

        assertTrue(fullPageBytes > viewportBytes,
            "Full page screenshot ($fullPageBytes bytes) should be larger than viewport ($viewportBytes bytes)")
    }
}
