@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnencodedDigestIssueDetails(
  @property:SerialName("error")
  val error: UnencodedDigestError,
  @property:SerialName("request")
  val request: AffectedRequest,
)
