package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration for dual screen hinge
 */
data class HingeConfig(
  @field:JsonProperty("rect")
  val rect: Rect,
  @field:JsonProperty("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @field:JsonProperty("outlineColor")
  @param:Optional
  val outlineColor: RGBA? = null,
)
