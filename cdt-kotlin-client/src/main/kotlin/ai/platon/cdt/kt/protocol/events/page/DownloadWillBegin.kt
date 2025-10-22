package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.String

/**
 * Fired when page is about to start a download.
 * Deprecated. Use Browser.downloadWillBegin instead.
 */
@Experimental
@Deprecated
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
