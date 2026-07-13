@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for issues around "Attribution Reporting API" usage.
 * Explainer: https://github.com/WICG/attribution-reporting-api
 */
@Serializable
data class AttributionReportingIssueDetails(
  @property:SerialName("violationType")
  val violationType: AttributionReportingIssueType,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @property:SerialName("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
  @property:SerialName("invalidParameter")
  @param:Optional
  val invalidParameter: String? = null,
)
