@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * This issue warns about uses of APIs that may be considered misuse to
 * re-identify users.
 */
data class UserReidentificationIssueDetails(
  @param:JsonProperty("type")
  val type: UserReidentificationIssueType,
  @param:JsonProperty("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @param:JsonProperty("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
)
