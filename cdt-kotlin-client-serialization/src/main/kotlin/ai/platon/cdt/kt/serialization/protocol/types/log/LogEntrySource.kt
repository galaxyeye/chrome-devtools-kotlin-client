@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Log entry source.
 */
@Serializable
public enum class LogEntrySource {
  @SerialName("xml")
  XML,
  @SerialName("javascript")
  JAVASCRIPT,
  @SerialName("network")
  NETWORK,
  @SerialName("storage")
  STORAGE,
  @SerialName("appcache")
  APPCACHE,
  @SerialName("rendering")
  RENDERING,
  @SerialName("security")
  SECURITY,
  @SerialName("deprecation")
  DEPRECATION,
  @SerialName("worker")
  WORKER,
  @SerialName("violation")
  VIOLATION,
  @SerialName("intervention")
  INTERVENTION,
  @SerialName("recommendation")
  RECOMMENDATION,
  @SerialName("other")
  OTHER,
}
