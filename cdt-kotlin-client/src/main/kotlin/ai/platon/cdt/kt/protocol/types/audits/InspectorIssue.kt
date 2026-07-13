@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * An inspector issue reported from the back-end.
 */
data class InspectorIssue(
  @param:JsonProperty("code")
  val code: InspectorIssueCode,
  @param:JsonProperty("details")
  val details: InspectorIssueDetails,
  @param:JsonProperty("issueId")
  @param:Optional
  val issueId: String? = null,
)
