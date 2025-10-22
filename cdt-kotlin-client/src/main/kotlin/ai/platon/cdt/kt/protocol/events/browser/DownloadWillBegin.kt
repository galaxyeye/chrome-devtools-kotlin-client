package ai.platon.cdt.kt.protocol.events.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when page is about to start a download.
 */
@Experimental
data class DownloadWillBegin(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("guid")
  val guid: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("suggestedFilename")
  val suggestedFilename: String,
)
