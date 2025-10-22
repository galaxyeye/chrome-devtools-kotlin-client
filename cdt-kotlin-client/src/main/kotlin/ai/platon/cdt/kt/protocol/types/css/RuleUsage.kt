package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * CSS coverage information.
 */
public data class RuleUsage(
  @field:JsonProperty("styleSheetId")
  public val styleSheetId: String,
  @field:JsonProperty("startOffset")
  public val startOffset: Double,
  @field:JsonProperty("endOffset")
  public val endOffset: Double,
  @field:JsonProperty("used")
  public val used: Boolean,
)
