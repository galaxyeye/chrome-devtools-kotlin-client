@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Serialized fragment of layer picture along with its offset within the layer.
 */
@Serializable
data class PictureTile(
  @SerialName("x")
  val x: Double,
  @SerialName("y")
  val y: Double,
  @SerialName("picture")
  val picture: String,
)
