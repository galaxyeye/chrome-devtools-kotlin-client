package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Layout viewport position and dimensions.
 */
data class LayoutViewport(
  @field:JsonProperty("pageX")
  val pageX: Int,
  @field:JsonProperty("pageY")
  val pageY: Int,
  @field:JsonProperty("clientWidth")
  val clientWidth: Int,
  @field:JsonProperty("clientHeight")
  val clientHeight: Int,
)
