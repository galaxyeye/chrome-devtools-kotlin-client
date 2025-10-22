package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * CSS coverage information.
 */
data class RuleUsage(
  @field:JsonProperty("styleSheetId")
  val styleSheetId: String,
  @field:JsonProperty("startOffset")
  val startOffset: Double,
  @field:JsonProperty("endOffset")
  val endOffset: Double,
  @field:JsonProperty("used")
  val used: Boolean,
)
