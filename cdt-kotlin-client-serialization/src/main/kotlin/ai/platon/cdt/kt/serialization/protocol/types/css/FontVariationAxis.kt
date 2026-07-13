@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about font variation axes for variable fonts
 */
@Serializable
data class FontVariationAxis(
  @property:SerialName("tag")
  val tag: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("minValue")
  val minValue: Double,
  @property:SerialName("maxValue")
  val maxValue: Double,
  @property:SerialName("defaultValue")
  val defaultValue: Double,
)
