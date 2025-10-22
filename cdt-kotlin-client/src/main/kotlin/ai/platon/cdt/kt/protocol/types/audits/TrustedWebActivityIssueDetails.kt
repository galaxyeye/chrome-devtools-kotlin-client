package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class TrustedWebActivityIssueDetails(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("violationType")
  public val violationType: TwaQualityEnforcementViolationType,
  @field:JsonProperty("httpStatusCode")
  @param:Optional
  public val httpStatusCode: Int? = null,
  @field:JsonProperty("packageName")
  @param:Optional
  public val packageName: String? = null,
  @field:JsonProperty("signature")
  @param:Optional
  public val signature: String? = null,
)
