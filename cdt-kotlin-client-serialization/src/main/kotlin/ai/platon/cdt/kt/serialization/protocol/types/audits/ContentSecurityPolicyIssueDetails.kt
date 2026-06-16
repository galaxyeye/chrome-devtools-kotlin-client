@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentSecurityPolicyIssueDetails(
  @property:SerialName("blockedURL")
  @param:Optional
  val blockedURL: String? = null,
  @property:SerialName("violatedDirective")
  val violatedDirective: String,
  @property:SerialName("isReportOnly")
  val isReportOnly: Boolean,
  @property:SerialName("contentSecurityPolicyViolationType")
  val contentSecurityPolicyViolationType: ContentSecurityPolicyViolationType,
  @property:SerialName("frameAncestor")
  @param:Optional
  val frameAncestor: AffectedFrame? = null,
  @property:SerialName("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
  @property:SerialName("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
)
