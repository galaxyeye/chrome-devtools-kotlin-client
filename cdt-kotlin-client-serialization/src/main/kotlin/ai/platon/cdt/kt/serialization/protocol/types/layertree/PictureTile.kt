@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 */
@Serializable
data class PictureTile(
  @property:SerialName("x")
  val x: Double,
  @property:SerialName("y")
  val y: Double,
  @property:SerialName("picture")
  val picture: String,
)
