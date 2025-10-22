package ai.platon.cdt.kt.protocol.events.layertree

import ai.platon.cdt.kt.protocol.types.dom.Rect
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class LayerPainted(
  @field:JsonProperty("layerId")
  public val layerId: String,
  @field:JsonProperty("clip")
  public val clip: Rect,
)
