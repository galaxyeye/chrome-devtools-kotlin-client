@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for a issue arising from an SAB being instantiated in, or
 * transferred to a context that is not cross-origin isolated.
 */
@Serializable
data class SharedArrayBufferIssueDetails(
  @property:SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @property:SerialName("isWarning")
  val isWarning: Boolean,
  @property:SerialName("type")
  val type: SharedArrayBufferIssueType,
)
