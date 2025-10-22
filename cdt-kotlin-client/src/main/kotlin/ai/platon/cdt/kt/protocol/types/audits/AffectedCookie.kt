package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Information about a cookie that is affected by an inspector issue.
 */
public data class AffectedCookie(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("path")
  public val path: String,
  @field:JsonProperty("domain")
  public val domain: String,
)
