@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty

data class SharedDictionaryIssueDetails(
  @param:JsonProperty("sharedDictionaryError")
  val sharedDictionaryError: SharedDictionaryError,
  @param:JsonProperty("request")
  val request: AffectedRequest,
)
