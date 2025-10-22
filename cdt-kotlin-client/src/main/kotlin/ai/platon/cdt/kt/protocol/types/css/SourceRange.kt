package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Text range within a resource. All numbers are zero-based.
 */
data class SourceRange(
  @field:JsonProperty("startLine")
  val startLine: Int,
  @field:JsonProperty("startColumn")
  val startColumn: Int,
  @field:JsonProperty("endLine")
  val endLine: Int,
  @field:JsonProperty("endColumn")
  val endColumn: Int,
)
