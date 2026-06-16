@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Depending on the concrete errorType, different properties are set.
 */
@Serializable
data class GenericIssueDetails(
  @property:SerialName("errorType")
  val errorType: GenericIssueErrorType,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
  @property:SerialName("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
  @property:SerialName("violatingNodeAttribute")
  @param:Optional
  val violatingNodeAttribute: String? = null,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
)
