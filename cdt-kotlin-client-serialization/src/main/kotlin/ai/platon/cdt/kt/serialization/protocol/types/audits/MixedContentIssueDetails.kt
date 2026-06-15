@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Serializable
data class MixedContentIssueDetails(
  @SerialName("resourceType")
  @param:Optional
  val resourceType: MixedContentResourceType? = null,
  @SerialName("resolutionStatus")
  val resolutionStatus: MixedContentResolutionStatus,
  @SerialName("insecureURL")
  val insecureURL: String,
  @SerialName("mainResourceURL")
  val mainResourceURL: String,
  @SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @SerialName("frame")
  @param:Optional
  val frame: AffectedFrame? = null,
)
