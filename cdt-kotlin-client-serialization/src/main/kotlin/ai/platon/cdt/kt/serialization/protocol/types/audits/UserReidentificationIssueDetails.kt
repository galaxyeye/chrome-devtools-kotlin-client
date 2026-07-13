@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about uses of APIs that may be considered misuse to
 * re-identify users.
 */
@Serializable
data class UserReidentificationIssueDetails(
  @property:SerialName("type")
  val type: UserReidentificationIssueType,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @property:SerialName("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
)
