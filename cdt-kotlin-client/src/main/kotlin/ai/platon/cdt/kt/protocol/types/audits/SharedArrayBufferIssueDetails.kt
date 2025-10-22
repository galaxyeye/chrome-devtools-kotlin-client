package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Details for a issue arising from an SAB being instantiated in, or
 * transferred to a context that is not cross-origin isolated.
 */
public data class SharedArrayBufferIssueDetails(
  @field:JsonProperty("sourceCodeLocation")
  public val sourceCodeLocation: SourceCodeLocation,
  @field:JsonProperty("isWarning")
  public val isWarning: Boolean,
  @field:JsonProperty("type")
  public val type: SharedArrayBufferIssueType,
)
