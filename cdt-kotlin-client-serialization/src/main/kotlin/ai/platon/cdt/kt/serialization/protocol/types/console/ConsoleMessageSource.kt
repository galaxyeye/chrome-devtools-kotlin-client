@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.console

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Message source.
 */
@Serializable
public enum class ConsoleMessageSource {
  @SerialName("xml")
  XML,
  @SerialName("javascript")
  JAVASCRIPT,
  @SerialName("network")
  NETWORK,
  @SerialName("console-api")
  CONSOLE_API,
  @SerialName("storage")
  STORAGE,
  @SerialName("appcache")
  APPCACHE,
  @SerialName("rendering")
  RENDERING,
  @SerialName("security")
  SECURITY,
  @SerialName("other")
  OTHER,
  @SerialName("deprecation")
  DEPRECATION,
  @SerialName("worker")
  WORKER,
  UNKNOWN,
}
