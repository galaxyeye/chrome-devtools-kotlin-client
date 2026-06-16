package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher
import ai.platon.pulsar.common.browser.BrowserFiles
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class ChromeTests {

    val JSON = Json {
        prettyPrint = true
    }

    @Test
    fun chromeLaunch() {
        val userDataDir = BrowserFiles.computeTestContextDir()
        // val userDataDir = BrowserFiles.computeRandomTmpContextDir("test")
        val launcher = ChromeLauncher(userDataDir)
        val chrome = launcher.launch()
        val version = chrome.version
        println("version: " + JSON.encodeToString(version))
        assertNotNull(version.browser)
        assertNotNull(version.v8Version)

        assertTrue(chrome.canConnect())
        val tab = chrome.createTab("https://example.com/")
        assertNotNull(tab.devtoolsFrontendUrl)
        assertNotNull(tab.isPageType())
    }
}
