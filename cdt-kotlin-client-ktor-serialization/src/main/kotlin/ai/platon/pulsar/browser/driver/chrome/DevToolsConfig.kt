package ai.platon.pulsar.browser.driver.chrome

import java.time.Duration

class DevToolsConfig(
    var readTimeout: Duration = Duration.ofSeconds(READ_TIMEOUT_SECONDS)
) {
    companion object {
        private const val READ_TIMEOUT_PROPERTY = "browser.driver.chrome.readTimeout"
        private val READ_TIMEOUT_SECONDS = System.getProperty(READ_TIMEOUT_PROPERTY, "30").toLong()
    }
}
