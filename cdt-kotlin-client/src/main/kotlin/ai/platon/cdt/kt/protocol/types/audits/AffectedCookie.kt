package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Information about a cookie that is affected by an inspector issue.
 */
data class AffectedCookie(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("path")
  val path: String,
  @field:JsonProperty("domain")
  val domain: String,
)
