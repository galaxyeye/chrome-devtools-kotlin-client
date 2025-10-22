package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Configuration for dual screen hinge
 */
public data class HingeConfig(
  @field:JsonProperty("rect")
  public val rect: Rect,
  @field:JsonProperty("contentColor")
  @param:Optional
  public val contentColor: RGBA? = null,
  @field:JsonProperty("outlineColor")
  @param:Optional
  public val outlineColor: RGBA? = null,
)
