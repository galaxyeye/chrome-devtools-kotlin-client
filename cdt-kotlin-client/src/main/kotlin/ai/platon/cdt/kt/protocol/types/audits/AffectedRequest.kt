package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Information about a request that is affected by an inspector issue.
 */
data class AffectedRequest(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
)
