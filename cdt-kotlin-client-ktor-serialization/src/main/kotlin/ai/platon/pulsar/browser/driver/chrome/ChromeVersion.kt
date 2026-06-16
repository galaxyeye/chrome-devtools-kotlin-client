package ai.platon.pulsar.browser.driver.chrome

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ChromeVersion {
    @SerialName("Browser")
    val browser: String? = null

    @SerialName("Protocol-Version")
    val protocolVersion: String? = null

    @SerialName("User-Agent")
    val userAgent: String? = null

    @SerialName("V8-Version")
    val v8Version: String? = null

    @SerialName("WebKit-Version")
    val webKitVersion: String? = null

    @SerialName("webSocketDebuggerUrl")
    val webSocketDebuggerUrl: String? = null
}
