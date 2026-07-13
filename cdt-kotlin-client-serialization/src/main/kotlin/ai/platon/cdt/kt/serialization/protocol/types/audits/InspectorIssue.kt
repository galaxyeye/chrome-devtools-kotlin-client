@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An inspector issue reported from the back-end.
 */
@Serializable
data class InspectorIssue(
  @property:SerialName("code")
  val code: InspectorIssueCode,
  @property:SerialName("details")
  val details: InspectorIssueDetails,
  @property:SerialName("issueId")
  @param:Optional
  val issueId: String? = null,
)
