@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String

@Serializable
data class ContentSecurityPolicyIssueDetails(
  @SerialName("blockedURL")
  @param:Optional
  val blockedURL: String? = null,
  @SerialName("violatedDirective")
  val violatedDirective: String,
  @SerialName("isReportOnly")
  val isReportOnly: Boolean,
  @SerialName("contentSecurityPolicyViolationType")
  val contentSecurityPolicyViolationType: ContentSecurityPolicyViolationType,
  @SerialName("frameAncestor")
  @param:Optional
  val frameAncestor: AffectedFrame? = null,
  @SerialName("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
  @SerialName("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
)
