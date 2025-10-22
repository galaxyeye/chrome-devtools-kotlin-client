package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about font variation axes for variable fonts
 */
data class FontVariationAxis(
  @field:JsonProperty("tag")
  val tag: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("minValue")
  val minValue: Double,
  @field:JsonProperty("maxValue")
  val maxValue: Double,
  @field:JsonProperty("defaultValue")
  val defaultValue: Double,
)
