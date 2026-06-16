@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class SRIMessageSignatureIssueDetails(
  @param:JsonProperty("error")
  val error: SRIMessageSignatureError,
  @param:JsonProperty("signatureBase")
  val signatureBase: String,
  @param:JsonProperty("integrityAssertions")
  val integrityAssertions: List<String>,
  @param:JsonProperty("request")
  val request: AffectedRequest,
)
