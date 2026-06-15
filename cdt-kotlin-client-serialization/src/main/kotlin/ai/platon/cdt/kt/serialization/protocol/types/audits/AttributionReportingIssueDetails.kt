@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

/**
 * Details for issues around "Attribution Reporting API" usage.
 * Explainer: https://github.com/WICG/conversion-measurement-api
 */
@Serializable
data class AttributionReportingIssueDetails(
  @SerialName("violationType")
  val violationType: AttributionReportingIssueType,
  @SerialName("frame")
  @param:Optional
  val frame: AffectedFrame? = null,
  @SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @SerialName("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
  @SerialName("invalidParameter")
  @param:Optional
  val invalidParameter: String? = null,
)
