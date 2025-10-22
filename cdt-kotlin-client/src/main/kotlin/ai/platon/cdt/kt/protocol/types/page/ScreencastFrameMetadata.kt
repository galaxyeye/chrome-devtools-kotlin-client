package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Screencast frame metadata.
 */
@Experimental
data class ScreencastFrameMetadata(
  @field:JsonProperty("offsetTop")
  val offsetTop: Double,
  @field:JsonProperty("pageScaleFactor")
  val pageScaleFactor: Double,
  @field:JsonProperty("deviceWidth")
  val deviceWidth: Double,
  @field:JsonProperty("deviceHeight")
  val deviceHeight: Double,
  @field:JsonProperty("scrollOffsetX")
  val scrollOffsetX: Double,
  @field:JsonProperty("scrollOffsetY")
  val scrollOffsetY: Double,
  @field:JsonProperty("timestamp")
  @param:Optional
  val timestamp: Double? = null,
)
