@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AttributionReportingIssueType {
  @SerialName("PermissionPolicyDisabled")
  PERMISSION_POLICY_DISABLED,
  @SerialName("InvalidAttributionSourceEventId")
  INVALID_ATTRIBUTION_SOURCE_EVENT_ID,
  @SerialName("InvalidAttributionData")
  INVALID_ATTRIBUTION_DATA,
  @SerialName("AttributionSourceUntrustworthyOrigin")
  ATTRIBUTION_SOURCE_UNTRUSTWORTHY_ORIGIN,
  @SerialName("AttributionUntrustworthyOrigin")
  ATTRIBUTION_UNTRUSTWORTHY_ORIGIN,
  UNKNOWN,
}
