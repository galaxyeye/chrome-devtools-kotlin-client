package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Information about font variation axes for variable fonts
 */
public data class FontVariationAxis(
  @field:JsonProperty("tag")
  public val tag: String,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("minValue")
  public val minValue: Double,
  @field:JsonProperty("maxValue")
  public val maxValue: Double,
  @field:JsonProperty("defaultValue")
  public val defaultValue: Double,
)
