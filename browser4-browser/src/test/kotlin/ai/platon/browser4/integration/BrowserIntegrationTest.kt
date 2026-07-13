package ai.platon.browser4.integration

import ai.platon.browser4.api.BrowserProtocol
import ai.platon.browser4.api.LauncherOptions
import ai.platon.browser4.api.ChromeOptions
import ai.platon.browser4.chrome.ChromeLauncher
import ai.platon.browser4.chrome.RemoteChrome
import ai.platon.browser4.chrome.RemoteDevTools
import ai.platon.browser4.chrome.protocol.DirectChromeProtocol
import ai.platon.pulsar.common.browser.BrowserFiles
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.slf4j.LoggerFactory

/**
 * Base class for real-browser integration tests.
 *
 * Provides Chrome lifecycle management and a shared [BrowserProtocol] instance.
 * Tests extending this class are tagged with "integration" and run via
 * Maven Failsafe Plugin (`mvn verify`), NOT via Surefire (`mvn test`).
 */
@Tag("integration")
abstract class BrowserIntegrationTest {

    protected val logger = LoggerFactory.getLogger(this::class.java)

    protected lateinit var chrome: RemoteChrome
    protected lateinit var devTools: RemoteDevTools
    protected lateinit var bp: BrowserProtocol
    protected lateinit var testServer: TestServer
    protected lateinit var baseUrl: String

    private var launcher: ChromeLauncher? = null

    @BeforeEach
    open fun setUp() {
        testServer = TestServer.start()
        baseUrl = testServer.baseUrl
        logger.info("Test server started at $baseUrl")

        val userDataDir = BrowserFiles.computeTestContextDir()
        launcher = ChromeLauncher(
            userDataDir = userDataDir,
            options = LauncherOptions()
        )
        chrome = launcher!!.launch(ChromeOptions().apply {
            headless = true
        })
        logger.info("Chrome launched, port=${chrome.port}, host=${chrome.host}")

        val tab = chrome.createTab()
        devTools = chrome.createDevTools(tab)
        bp = DirectChromeProtocol(devTools)

        runBlocking {
            bp.pageEnable()
            bp.domEnable()
            bp.runtimeEnable()
        }
        logger.info("CDP domains enabled")
    }

    @AfterEach
    open fun tearDown() {
        runCatching { bp.close() }
        runCatching { chrome.close() }
        runCatching { launcher?.close() }
        runCatching { testServer.stop() }
    }
}
