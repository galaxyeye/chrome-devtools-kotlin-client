@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Depending on the concrete errorType, different properties are set.
 */
data class GenericIssueDetails(
  @param:JsonProperty("errorType")
  val errorType: GenericIssueErrorType,
  @param:JsonProperty("frameId")
  @param:Optional
  val frameId: String? = null,
  @param:JsonProperty("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
  @param:JsonProperty("violatingNodeAttribute")
  @param:Optional
  val violatingNodeAttribute: String? = null,
  @param:JsonProperty("request")
  @param:Optional
  val request: AffectedRequest? = null,
)
