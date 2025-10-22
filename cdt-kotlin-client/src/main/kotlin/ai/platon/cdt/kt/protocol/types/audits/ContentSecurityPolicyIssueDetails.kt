package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

data class ContentSecurityPolicyIssueDetails(
  @field:JsonProperty("blockedURL")
  @param:Optional
  val blockedURL: String? = null,
  @field:JsonProperty("violatedDirective")
  val violatedDirective: String,
  @field:JsonProperty("isReportOnly")
  val isReportOnly: Boolean,
  @field:JsonProperty("contentSecurityPolicyViolationType")
  val contentSecurityPolicyViolationType: ContentSecurityPolicyViolationType,
  @field:JsonProperty("frameAncestor")
  @param:Optional
  val frameAncestor: AffectedFrame? = null,
  @field:JsonProperty("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
  @field:JsonProperty("violatingNodeId")
  @param:Optional
  val violatingNodeId: Int? = null,
)
