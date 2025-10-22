package ai.platon.cdt.kt.protocol.types.layertree

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 */
data class PictureTile(
  @field:JsonProperty("x")
  val x: Double,
  @field:JsonProperty("y")
  val y: Double,
  @field:JsonProperty("picture")
  val picture: String,
)
