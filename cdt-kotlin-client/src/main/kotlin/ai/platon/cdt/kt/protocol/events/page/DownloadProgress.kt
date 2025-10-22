package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.page.DownloadProgressState
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Double
import kotlin.String

/**
 * Fired when download makes progress. Last call has |done| == true.
 * Deprecated. Use Browser.downloadProgress instead.
 */
@Experimental
@Deprecated
data class DownloadProgress(
  @field:JsonProperty("guid")
  val guid: String,
  @field:JsonProperty("totalBytes")
  val totalBytes: Double,
  @field:JsonProperty("receivedBytes")
  val receivedBytes: Double,
  @field:JsonProperty("state")
  val state: DownloadProgressState,
)
