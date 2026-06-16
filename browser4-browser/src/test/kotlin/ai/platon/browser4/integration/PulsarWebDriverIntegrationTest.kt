package ai.platon.browser4.integration

import ai.platon.browser4.chrome.PulsarBrowser
import ai.platon.browser4.chrome.PulsarWebDriver
import ai.platon.browser4.api.BrowserId
import ai.platon.browser4.api.BrowserProtocol
import ai.platon.browser4.api.model.BrowserSettings
import ai.platon.browser4.api.model.NavigateEntry
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PulsarWebDriverIntegrationTest : BrowserIntegrationTest() {

    @Test
    @DisplayName("PulsarBrowser creates driver and navigates successfully")
    fun testBrowserCreatesDriver() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/simple.html") as PulsarWebDriver

        try {
            val url = driver.currentUrl()
            assertTrue(url.contains("simple.html"), "Current URL should contain simple.html, got: $url")

            val pageSource = driver.pageSource()
            assertNotNull(pageSource)
            assertTrue(pageSource!!.contains("Hello World"), "Page source should contain heading text")
            assertTrue(pageSource.contains("<h1"), "Page source should contain h1 tag")
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("driver click on button works")
    fun testDriverClick() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/form.html") as PulsarWebDriver

        try {
            driver.click("#submit-btn")

            // Verify button was clicked
            val btnText = driver.evaluate("document.getElementById('submit-btn').textContent")
            assertEquals("clicked", btnText)
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("driver fill and verify input value")
    fun testDriverFill() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/form.html") as PulsarWebDriver

        try {
            driver.fill("#name", "John Doe")

            val value = driver.evaluate("document.getElementById('name').value")
            assertEquals("John Doe", value)
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("driver navigate with NavigateEntry works")
    fun testDriverNavigateWithEntry() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver() as PulsarWebDriver

        try {
            val entry = NavigateEntry(url = "$baseUrl/simple.html")
            driver.navigate(entry)

            val url = driver.currentUrl()
            assertTrue(url.contains("simple.html"))
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("driver screenshot works")
    fun testDriverScreenshot() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/simple.html") as PulsarWebDriver

        try {
            val screenshot = driver.screenshot()
            assertNotNull(screenshot)
            assertTrue(screenshot!!.isNotBlank())
        } finally {
            driver.close()
            browser.close()
        }
    }
}
