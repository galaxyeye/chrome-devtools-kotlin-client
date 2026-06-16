@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.DownloadProgressState
import kotlin.Deprecated
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when download makes progress. Last call has |done| == true.
 * Deprecated. Use Browser.downloadProgress instead.
 */
@Serializable
@Experimental
@Deprecated("Deprecated")
data class DownloadProgress(
  @property:SerialName("guid")
  val guid: String,
  @property:SerialName("totalBytes")
  val totalBytes: Double,
  @property:SerialName("receivedBytes")
  val receivedBytes: Double,
  @property:SerialName("state")
  val state: DownloadProgressState,
)
