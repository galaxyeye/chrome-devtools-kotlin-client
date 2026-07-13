package ai.platon.pulsar.browser.driver.chrome

import ai.platon.pulsar.browser.driver.chrome.util.ChromeServiceException

interface ChromeService : AutoCloseable {

    val isActive: Boolean

    val version: ChromeVersion

    val host: String

    val port: Int

    fun canConnect(): Boolean

    @Throws(ChromeServiceException::class)
    fun listTabs(): Array<BrowserTab>

    @Throws(ChromeServiceException::class)
    fun createTab(): BrowserTab

    @Throws(ChromeServiceException::class)
    fun createTab(url: String): BrowserTab

    @Throws(ChromeServiceException::class)
    fun activateTab(tab: BrowserTab)

    @Throws(ChromeServiceException::class)
    fun closeTab(tab: BrowserTab)

    @Throws(ChromeServiceException::class)
    fun createDevTools(tab: BrowserTab, config: DevToolsConfig = DevToolsConfig()): ChromeDevToolsService

    // Compatibility
    @Throws(ChromeServiceException::class)
    fun createDevToolsService(tab: BrowserTab): ChromeDevToolsService = createDevTools(tab, DevToolsConfig())

    // Compatibility
    @Throws(ChromeServiceException::class)
    fun createDevToolsService(tab: BrowserTab, config: DevToolsConfig = DevToolsConfig()): ChromeDevToolsService =
        createDevTools(tab, config)
}
