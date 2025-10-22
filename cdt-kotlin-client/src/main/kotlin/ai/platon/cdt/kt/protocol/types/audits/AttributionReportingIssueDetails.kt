package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Details for issues around "Attribution Reporting API" usage.
 * Explainer: https://github.com/WICG/conversion-measurement-api
 */
public data class AttributionReportingIssueDetails(
  @field:JsonProperty("violationType")
  public val violationType: AttributionReportingIssueType,
  @field:JsonProperty("frame")
  @param:Optional
  public val frame: AffectedFrame? = null,
  @field:JsonProperty("request")
  @param:Optional
  public val request: AffectedRequest? = null,
  @field:JsonProperty("violatingNodeId")
  @param:Optional
  public val violatingNodeId: Int? = null,
  @field:JsonProperty("invalidParameter")
  @param:Optional
  public val invalidParameter: String? = null,
)
