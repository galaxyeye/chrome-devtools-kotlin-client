package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Text range within a resource. All numbers are zero-based.
 */
public data class SourceRange(
  @field:JsonProperty("startLine")
  public val startLine: Int,
  @field:JsonProperty("startColumn")
  public val startColumn: Int,
  @field:JsonProperty("endLine")
  public val endLine: Int,
  @field:JsonProperty("endColumn")
  public val endColumn: Int,
)
