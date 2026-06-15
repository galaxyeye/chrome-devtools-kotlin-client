@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.DownloadProgressState
import kotlin.Deprecated
import kotlin.Double
import kotlin.String

/**
 * Fired when download makes progress. Last call has |done| == true.
 * Deprecated. Use Browser.downloadProgress instead.
 */
@Experimental
@Deprecated("Deprecated")
@Serializable
data class DownloadProgress(
  @SerialName("guid")
  val guid: String,
  @SerialName("totalBytes")
  val totalBytes: Double,
  @SerialName("receivedBytes")
  val receivedBytes: Double,
  @SerialName("state")
  val state: DownloadProgressState,
)
