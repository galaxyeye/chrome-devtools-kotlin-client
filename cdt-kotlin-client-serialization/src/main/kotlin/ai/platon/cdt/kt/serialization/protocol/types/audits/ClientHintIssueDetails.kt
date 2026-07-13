@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue tracks client hints related issues. It's used to deprecate old
 * features, encourage the use of new ones, and provide general guidance.
 */
@Serializable
data class ClientHintIssueDetails(
  @property:SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @property:SerialName("clientHintIssueReason")
  val clientHintIssueReason: ClientHintIssueReason,
)
