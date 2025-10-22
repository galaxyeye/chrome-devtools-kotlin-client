package ai.platon.cdt.kt.protocol.events.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.browser.DownloadProgressState
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired when download makes progress. Last call has |done| == true.
 */
@Experimental
public data class DownloadProgress(
  @field:JsonProperty("guid")
  public val guid: String,
  @field:JsonProperty("totalBytes")
  public val totalBytes: Double,
  @field:JsonProperty("receivedBytes")
  public val receivedBytes: Double,
  @field:JsonProperty("state")
  public val state: DownloadProgressState,
)
