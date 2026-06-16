@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MixedContentIssueDetails(
  @property:SerialName("resourceType")
  @param:Optional
  val resourceType: MixedContentResourceType? = null,
  @property:SerialName("resolutionStatus")
  val resolutionStatus: MixedContentResolutionStatus,
  @property:SerialName("insecureURL")
  val insecureURL: String,
  @property:SerialName("mainResourceURL")
  val mainResourceURL: String,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @property:SerialName("frame")
  @param:Optional
  val frame: AffectedFrame? = null,
)
