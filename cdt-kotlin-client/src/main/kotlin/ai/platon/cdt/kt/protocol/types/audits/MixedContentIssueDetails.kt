package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class MixedContentIssueDetails(
  @field:JsonProperty("resourceType")
  @param:Optional
  val resourceType: MixedContentResourceType? = null,
  @field:JsonProperty("resolutionStatus")
  val resolutionStatus: MixedContentResolutionStatus,
  @field:JsonProperty("insecureURL")
  val insecureURL: String,
  @field:JsonProperty("mainResourceURL")
  val mainResourceURL: String,
  @field:JsonProperty("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @field:JsonProperty("frame")
  @param:Optional
  val frame: AffectedFrame? = null,
)
