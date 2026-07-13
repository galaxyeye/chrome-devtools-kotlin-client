package ai.platon.browser4.integration

import ai.platon.browser4.chrome.ChromeLauncher
import ai.platon.browser4.chrome.RemoteChrome
import ai.platon.browser4.chrome.RemoteDevTools
import ai.platon.browser4.chrome.protocol.DirectChromeProtocol
import ai.platon.browser4.api.ChromeOptions
import ai.platon.browser4.api.LauncherOptions
import ai.platon.pulsar.common.browser.BrowserFiles
import ai.platon.pulsar.common.browser.BrowserFiles.CDP_URL_FILE_NAME
import ai.platon.pulsar.common.serialize.json.Pson
import ai.platon.pulsar.common.serialize.json.prettyPulsarObjectMapper
import ai.platon.pulsar.common.sleepSeconds
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Tag
import java.nio.file.Files
import kotlin.test.Test
import kotlin.test.assertTrue

@Tag("integration")
class ChromeImplLauncherTest {
    private val USER_DATA_DIR_REGEX = ".+pulsar-.+/context/cx.+".toRegex()

    @Test
    fun testUserDataDirRegex() {
        val text = """
            |xvfb-run -a -e /dev/stdout -s "-screen 0 1920x1080x24" /usr/bin/google-chrome-stable
            |--proxy-server=119.49.122.242:4224 --disable-gpu --hide-scrollbars --remote-debugging-port=0
            |--no-default-browser-check --no-first-run --no-startup-window --mute-audio
            |--disable-background-networking --disable-background-timer-throttling
            |--disable-client-side-phishing-detection --disable-hang-monitor
            |--disable-popup-blocking --disable-prompt-on-repost --disable-sync --disable-translate
            |--disable-blink-features=AutomationControlled --metrics-recording-only
            |--safebrowsing-disable-auto-update --no-sandbox --ignore-certificate-errors
            |--window-size=1920,1080 --pageLoadStrategy=none --throwExceptionOnScriptError=true
            |--user-data-dir=/home/vincent/tmp/pulsar-vincent/context/cx.2zmmAe40/pulsar_chrome
        """.trimMargin().replace("\n", " ")

        assertTrue { "./pulsar-vincent/context/cx.5oruW037".matches(USER_DATA_DIR_REGEX) }
        assertTrue { text.matches(USER_DATA_DIR_REGEX) }
    }

    @Test
    fun testChromeLauncher() {
        val launchOptions = ChromeOptions()
        launchOptions.headless = false

        val userDataDir = BrowserFiles.computeTestContextDir()

        val launcher = ChromeLauncher(userDataDir, options = LauncherOptions())
        launcher.use {
            val chrome = launcher.launch(launchOptions)

            val version = chrome.version
            val tab = chrome.createTab("https://www.example.com/")
            val versionString = Pson.toJson(chrome.version)
            assertTrue(!chrome.version.browser.isNullOrBlank())
            assertTrue(versionString.contains("Mozilla"))

            println("Tab id: " + tab.id)
            println("Protocol version: " + version.protocolVersion)
            println("Browser version: " + version.browser)

            println(prettyPulsarObjectMapper().writeValueAsString(tab))
            println(prettyPulsarObjectMapper().writeValueAsString(chrome.version))
            println(versionString)

            val devTools = chrome.createDevTools(tab)
            val browserProtocol = DirectChromeProtocol(devTools)
            runBlocking {
                browserProtocol.pageEnable()
                browserProtocol.navigate("https://vercel.com/")
            }

            sleepSeconds(2)
        }
    }

    @Test
    fun testCdpUrlTracking() {
        val launchOptions = ChromeOptions()
        launchOptions.headless = true

        val userDataDir = BrowserFiles.computeTestContextDir()
        val cdpUrlPath = userDataDir.resolveSibling(CDP_URL_FILE_NAME)

        val launcher = ChromeLauncher(userDataDir, options = LauncherOptions())
        launcher.use {
            val chrome = launcher.launch(launchOptions)

            assertTrue(Files.exists(cdpUrlPath), "CDP URL file should exist")

            val cdpUrl = Files.readString(cdpUrlPath).trim()
            assertTrue(cdpUrl.isNotBlank(), "CDP URL should not be blank")
            assertTrue(cdpUrl.startsWith("ws://"), "CDP URL should start with ws://")
            assertTrue(cdpUrl.contains("/devtools/browser/"), "CDP URL should contain devtools path")

            println("CDP URL: $cdpUrl")

            val version = chrome.version
            assertTrue(!version.browser.isNullOrBlank(), "Browser version should not be blank")

            sleepSeconds(1)
        }
    }

    @Test
    fun testBrowserReuse() {
        val launchOptions = ChromeOptions()
        launchOptions.headless = true

        val userDataDir = BrowserFiles.computeRandomTmpContextDir()
        val cdpUrlPath = userDataDir.resolveSibling(CDP_URL_FILE_NAME)

        val launcher1 = ChromeLauncher(userDataDir, options = LauncherOptions())
        val chrome1 = launcher1.launch(launchOptions)

        assertTrue(Files.exists(cdpUrlPath), "CDP URL file should exist after first launch")
        val cdpUrl1 = Files.readString(cdpUrlPath).trim()
        println("First launch CDP URL: $cdpUrl1")

        val launcher2 = ChromeLauncher(userDataDir, options = LauncherOptions())
        val chrome2 = launcher2.launch(launchOptions)

        assertTrue(Files.exists(cdpUrlPath), "CDP URL file should still exist")
        val cdpUrl2 = Files.readString(cdpUrlPath).trim()
        println("Second launch CDP URL: $cdpUrl2")

        assertTrue(cdpUrl2.isNotBlank(), "CDP URL should not be blank on reuse")

        launcher1.close()
        launcher2.close()
    }
}
