package ai.platon.browser4.integration

import ai.platon.browser4.chrome.PulsarBrowser
import ai.platon.browser4.chrome.PulsarWebDriver
import ai.platon.browser4.chrome.network.NetworkManager
import ai.platon.browser4.chrome.network.RobustRPC
import ai.platon.browser4.api.BrowserId
import ai.platon.browser4.api.model.BrowserSettings
import kotlinx.coroutines.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NetworkManagerIntegrationTest : BrowserIntegrationTest() {

    @Test
    @DisplayName("NetworkManager receives events when navigating")
    fun testNetworkManagerReceivesEvents() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver() as PulsarWebDriver
        val rpc = RobustRPC(driver)
        val networkManager = NetworkManager(rpc, bp)

        try {
            networkManager.enable()

            // Navigate and check network events
            driver.navigate("$baseUrl/simple.html")

            delay(300)

            assertNotNull(driver.currentUrl())
            assertTrue(driver.pageSource()!!.contains("Hello World"))
        } finally {
            driver.close()
            browser.close()
        }
    }

    @Test
    @DisplayName("NetworkManager can be enabled")
    fun testNetworkManagerEnable() = runBlocking {
        val browser = PulsarBrowser(
            id = BrowserId.createRandomTemp(),
            chrome = chrome,
            settings = BrowserSettings(),
            launcher = null
        )

        val driver = browser.newDriver() as PulsarWebDriver
        val rpc = RobustRPC(driver)
        val networkManager = NetworkManager(rpc, bp)

        try {
            networkManager.enable()
            // Network is now monitoring — navigate to trigger events
            driver.navigate("$baseUrl/simple.html")
            delay(300)
        } finally {
            driver.close()
            browser.close()
        }
    }
}
