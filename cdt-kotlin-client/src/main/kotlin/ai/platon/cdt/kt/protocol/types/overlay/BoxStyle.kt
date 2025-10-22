package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Style information for drawing a box.
 */
public data class BoxStyle(
  @field:JsonProperty("fillColor")
  @param:Optional
  public val fillColor: RGBA? = null,
  @field:JsonProperty("hatchColor")
  @param:Optional
  public val hatchColor: RGBA? = null,
)
