package ai.platon.browser4.integration

import ai.platon.browser4.chrome.PulsarBrowser
import ai.platon.browser4.chrome.PulsarWebDriver
import ai.platon.browser4.chrome.network.RobustRPC
import ai.platon.browser4.api.BrowserId
import ai.platon.browser4.api.model.BrowserSettings
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RobustRPCIntegrationTest : BrowserIntegrationTest() {

    @Test
    @DisplayName("RobustRPC invoke succeeds for valid CDP call")
    fun testRobustRPCInvokeSucceeds() {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/simple.html") as PulsarWebDriver
        val rpc = RobustRPC(driver)

        try {
            val result = runBlocking {
                rpc.invoke("test-navigate") {
                    driver.navigate("$baseUrl/form.html")
                    "success"
                }
            }
            assertEquals("success", result)
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("RobustRPC handles error from invalid navigation gracefully")
    fun testRobustRPCHandlesInvalidURL() {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver() as PulsarWebDriver
        val rpc = RobustRPC(driver)

        try {
            val result = runBlocking {
                rpc.invoke("test-bad-url") {
                    // This may throw or return null depending on CDP behavior
                    runCatching { bp.navigate("http://invalid.example.invalid:99999/") }
                    null
                }
            }
            // Should return null without crashing
            assertNull(result)
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("RobustRPC invokeSilently does not throw")
    fun testRobustRPCInvokeSilently() {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver("$baseUrl/simple.html") as PulsarWebDriver
        val rpc = RobustRPC(driver)

        try {
            val result = runBlocking {
                rpc.invokeSilently("test-silent") {
                    "quiet-result"
                }
            }
            assertEquals("quiet-result", result)
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("RobustRPC predicateOnPage succeeds")
    fun testRobustRPCPredicateOnPage() {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver() as PulsarWebDriver
        val rpc = RobustRPC(driver)

        try {
            runBlocking {
                driver.navigate("$baseUrl/simple.html")
            }

            val result = runBlocking {
                rpc.predicateOnPage(
                    action = "check-heading",
                    url = "$baseUrl/simple.html",
                    message = "Checking heading exists"
                ) {
                    val source = driver.pageSource()
                    source != null && source.contains("Hello World")
                }
            }
            assertTrue(result, "Predicate should return true for matching content")
        } finally {
            driver.close()
            browser.close()
        }
    }
}
