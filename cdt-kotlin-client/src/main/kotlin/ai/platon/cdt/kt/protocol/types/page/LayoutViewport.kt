package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Layout viewport position and dimensions.
 */
public data class LayoutViewport(
  @field:JsonProperty("pageX")
  public val pageX: Int,
  @field:JsonProperty("pageY")
  public val pageY: Int,
  @field:JsonProperty("clientWidth")
  public val clientWidth: Int,
  @field:JsonProperty("clientHeight")
  public val clientHeight: Int,
)
