package ai.platon.pulsar.browser.common

import ai.platon.pulsar.browser.driver.chrome.common.ChromeOptions
import ai.platon.pulsar.common.config.AppConstants
import ai.platon.pulsar.common.config.CapabilityTypes
import ai.platon.pulsar.common.config.ImmutableConfig
import ai.platon.pulsar.common.proxy.ProxyEntry
import java.awt.Dimension
import java.net.URI

open class BrowserSettings constructor(
    /**
     * The configuration.
     * */
    val config: ImmutableConfig = ImmutableConfig(loadDefaults = true)
) {
    companion object {
        /**
         * The viewport size for browser to rendering all webpages.
         * */
        var SCREEN_VIEWPORT = AppConstants.DEFAULT_VIEW_PORT

        /**
         * The screenshot quality.
         * Compression quality from range [0..100] (jpeg only) to capture screenshots.
         * */
        var SCREENSHOT_QUALITY = 50

        /**
         * The default script confuser, which is used to confuse the javascript that will be injected to the webpage.
         *
         * If you want to use a custom script confuser, you need to set the field before the BrowserSettings object is created.
         * If you are using spring boot, you should set the field in a ApplicationContextInitializer.
         * */
        var SCRIPT_CONFUSER: ScriptConfuser = SimpleScriptConfuser()

    }
    /**
     * The script confuser.
     * */
    val confuser = BrowserSettings.SCRIPT_CONFUSER
    /**
     * The script loader.
     * */
    val scriptLoader = ScriptLoader(confuser, jsPropertyNames)
    /**
     * The javascript to execute by Web browsers.
     * */
    private val jsPropertyNames: List<String>
        get() = config[CapabilityTypes.FETCH_CLIENT_JS_COMPUTED_STYLES, AppConstants.CLIENT_JS_PROPERTY_NAMES].split(", ")

    /**
     * The screen viewport.
     * */
    val viewportSize get() = Dimension(1920, 1080);

    /**
     * The supervisor process
     * */
    val supervisorProcess get() = config.get(CapabilityTypes.BROWSER_LAUNCH_SUPERVISOR_PROCESS)
    /**
     * The supervisor process arguments
     * */
    val supervisorProcessArgs get() = config.getTrimmedStringCollection(CapabilityTypes.BROWSER_LAUNCH_SUPERVISOR_PROCESS_ARGS)

    /**
     * Add a --no-sandbox flag to launch the chrome if we are running inside a virtual machine,
     * for example, virtualbox, vmware or WSL
     * */
    val noSandbox get() = config.getBoolean(CapabilityTypes.BROWSER_LAUNCH_NO_SANDBOX, true)

    /**
     * Check if it's SPA mode, SPA stands for Single Page Application.
     *
     * If PulsarPRA works in SPA mode:
     * 1. execution of loads and fetches has no timeout limit, so we can interact with the page as long as we want.
     * */
    val isSPA get() = config.getBoolean(CapabilityTypes.BROWSER_SPA_MODE, false)
    /**
     * The probability to block resource requests.
     * The probability must be in [0, 1].
     * */
    val resourceBlockProbability get() = config.getFloat(CapabilityTypes.BROWSER_RESOURCE_BLOCK_PROBABILITY, 0.0f)
    /**
     * Check if user agent overriding is enabled. User agent overriding is disabled by default,
     * because inappropriate user agent overriding can be detected by the website,
     * furthermore, there is no obvious benefits to rotate the user agent.
     * */
    val isUserAgentOverridingEnabled get() = config.getBoolean(CapabilityTypes.BROWSER_ENABLE_UA_OVERRIDING, false)

    val fetchTaskTimeout get() = config.getDuration(
        CapabilityTypes.FETCH_TASK_TIMEOUT,
        AppConstants.FETCH_TASK_TIMEOUT_DEFAULT
    )

    val pollingDriverTimeout get() = config.getDuration(
        CapabilityTypes.POLLING_DRIVER_TIMEOUT,
        AppConstants.POLLING_DRIVER_TIMEOUT_DEFAULT
    )
    /**
     * Page load strategy.
     *
     * Browser4 checks document ready using javascript so just set the strategy to be none.
     *
     * @see <a href='https://blog.knoldus.com/page-loading-strategy-in-the-selenium-webdriver/'>
     *     Page Loading Strategy</a>
     * */
    var pageLoadStrategy = "none"

    open fun createChromeOptions(generalOptions: Map<String, Any>): ChromeOptions {
        val chromeOptions = ChromeOptions()
        chromeOptions.merge(generalOptions)

        // rewrite proxy argument
        chromeOptions.removeArgument("proxy")
        when (val proxy = generalOptions["proxy"]) {
            is String -> chromeOptions.proxyServer = proxy
            is URI -> chromeOptions.proxyServer = proxy.host + ":" + proxy.port
            is ProxyEntry -> chromeOptions.proxyServer = proxy.hostPort
        }

        chromeOptions.noSandbox = noSandbox

        chromeOptions
            .addArgument("window-position", "0,0")
            .addArgument("window-size", formatViewPort())
            .addArgument("pageLoadStrategy", pageLoadStrategy)
            .addArgument("throwExceptionOnScriptError", "true")
//            .addArgument("start-maximized")

        return chromeOptions
    }

    open fun formatViewPort(delimiter: String = ","): String {
        return "${viewportSize.width}$delimiter${viewportSize.height}"
    }

}