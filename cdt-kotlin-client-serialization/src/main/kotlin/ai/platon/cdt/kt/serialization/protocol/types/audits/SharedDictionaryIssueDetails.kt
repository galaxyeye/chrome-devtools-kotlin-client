@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SharedDictionaryIssueDetails(
  @property:SerialName("sharedDictionaryError")
  val sharedDictionaryError: SharedDictionaryError,
  @property:SerialName("request")
  val request: AffectedRequest,
)
