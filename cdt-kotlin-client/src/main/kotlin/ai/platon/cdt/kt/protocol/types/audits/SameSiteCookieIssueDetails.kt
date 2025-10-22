package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * This information is currently necessary, as the front-end has a difficult
 * time finding a specific cookie. With this, we can convey specific error
 * information without the cookie.
 */
public data class SameSiteCookieIssueDetails(
  @field:JsonProperty("cookie")
  public val cookie: AffectedCookie,
  @field:JsonProperty("cookieWarningReasons")
  public val cookieWarningReasons: List<SameSiteCookieWarningReason>,
  @field:JsonProperty("cookieExclusionReasons")
  public val cookieExclusionReasons: List<SameSiteCookieExclusionReason>,
  @field:JsonProperty("operation")
  public val operation: SameSiteCookieOperation,
  @field:JsonProperty("siteForCookies")
  @param:Optional
  public val siteForCookies: String? = null,
  @field:JsonProperty("cookieUrl")
  @param:Optional
  public val cookieUrl: String? = null,
  @field:JsonProperty("request")
  @param:Optional
  public val request: AffectedRequest? = null,
)
