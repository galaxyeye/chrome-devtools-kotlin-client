@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SRIMessageSignatureIssueDetails(
  @property:SerialName("error")
  val error: SRIMessageSignatureError,
  @property:SerialName("signatureBase")
  val signatureBase: String,
  @property:SerialName("integrityAssertions")
  val integrityAssertions: List<String>,
  @property:SerialName("request")
  val request: AffectedRequest,
)
