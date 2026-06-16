@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * This issue tracks client hints related issues. It's used to deprecate old
 * features, encourage the use of new ones, and provide general guidance.
 */
data class ClientHintIssueDetails(
  @param:JsonProperty("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @param:JsonProperty("clientHintIssueReason")
  val clientHintIssueReason: ClientHintIssueReason,
)
