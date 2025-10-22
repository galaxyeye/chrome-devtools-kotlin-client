package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class TrustedWebActivityIssueDetails(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("violationType")
  val violationType: TwaQualityEnforcementViolationType,
  @field:JsonProperty("httpStatusCode")
  @param:Optional
  val httpStatusCode: Int? = null,
  @field:JsonProperty("packageName")
  @param:Optional
  val packageName: String? = null,
  @field:JsonProperty("signature")
  @param:Optional
  val signature: String? = null,
)
