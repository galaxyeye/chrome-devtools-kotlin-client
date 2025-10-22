package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class MixedContentIssueDetails(
  @field:JsonProperty("resourceType")
  @param:Optional
  public val resourceType: MixedContentResourceType? = null,
  @field:JsonProperty("resolutionStatus")
  public val resolutionStatus: MixedContentResolutionStatus,
  @field:JsonProperty("insecureURL")
  public val insecureURL: String,
  @field:JsonProperty("mainResourceURL")
  public val mainResourceURL: String,
  @field:JsonProperty("request")
  @param:Optional
  public val request: AffectedRequest? = null,
  @field:JsonProperty("frame")
  @param:Optional
  public val frame: AffectedFrame? = null,
)
