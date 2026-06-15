@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Information about font variation axes for variable fonts
 */
@Serializable
data class FontVariationAxis(
  @SerialName("tag")
  val tag: String,
  @SerialName("name")
  val name: String,
  @SerialName("minValue")
  val minValue: Double,
  @SerialName("maxValue")
  val maxValue: Double,
  @SerialName("defaultValue")
  val defaultValue: Double,
)
