@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean

/**
 * Details for a issue arising from an SAB being instantiated in, or
 * transferred to a context that is not cross-origin isolated.
 */
@Serializable
data class SharedArrayBufferIssueDetails(
  @SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @SerialName("isWarning")
  val isWarning: Boolean,
  @SerialName("type")
  val type: SharedArrayBufferIssueType,
)
