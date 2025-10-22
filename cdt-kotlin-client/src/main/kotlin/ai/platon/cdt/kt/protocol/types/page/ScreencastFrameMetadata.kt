package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Screencast frame metadata.
 */
@Experimental
public data class ScreencastFrameMetadata(
  @field:JsonProperty("offsetTop")
  public val offsetTop: Double,
  @field:JsonProperty("pageScaleFactor")
  public val pageScaleFactor: Double,
  @field:JsonProperty("deviceWidth")
  public val deviceWidth: Double,
  @field:JsonProperty("deviceHeight")
  public val deviceHeight: Double,
  @field:JsonProperty("scrollOffsetX")
  public val scrollOffsetX: Double,
  @field:JsonProperty("scrollOffsetY")
  public val scrollOffsetY: Double,
  @field:JsonProperty("timestamp")
  @param:Optional
  public val timestamp: Double? = null,
)
