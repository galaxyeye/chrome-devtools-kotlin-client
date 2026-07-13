@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Download status.
 */
@Serializable
public enum class DownloadProgressState {
  @SerialName("inProgress")
  IN_PROGRESS,
  @SerialName("completed")
  COMPLETED,
  @SerialName("canceled")
  CANCELED,
  UNKNOWN,
}
