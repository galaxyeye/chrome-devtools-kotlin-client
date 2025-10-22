package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class ContentSecurityPolicyIssueDetails(
  @field:JsonProperty("blockedURL")
  @param:Optional
  public val blockedURL: String? = null,
  @field:JsonProperty("violatedDirective")
  public val violatedDirective: String,
  @field:JsonProperty("isReportOnly")
  public val isReportOnly: Boolean,
  @field:JsonProperty("contentSecurityPolicyViolationType")
  public val contentSecurityPolicyViolationType: ContentSecurityPolicyViolationType,
  @field:JsonProperty("frameAncestor")
  @param:Optional
  public val frameAncestor: AffectedFrame? = null,
  @field:JsonProperty("sourceCodeLocation")
  @param:Optional
  public val sourceCodeLocation: SourceCodeLocation? = null,
  @field:JsonProperty("violatingNodeId")
  @param:Optional
  public val violatingNodeId: Int? = null,
)
