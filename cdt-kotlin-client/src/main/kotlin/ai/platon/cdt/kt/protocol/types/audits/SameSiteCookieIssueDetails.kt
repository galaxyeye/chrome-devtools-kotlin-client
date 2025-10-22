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
data class SameSiteCookieIssueDetails(
  @field:JsonProperty("cookie")
  val cookie: AffectedCookie,
  @field:JsonProperty("cookieWarningReasons")
  val cookieWarningReasons: List<SameSiteCookieWarningReason>,
  @field:JsonProperty("cookieExclusionReasons")
  val cookieExclusionReasons: List<SameSiteCookieExclusionReason>,
  @field:JsonProperty("operation")
  val operation: SameSiteCookieOperation,
  @field:JsonProperty("siteForCookies")
  @param:Optional
  val siteForCookies: String? = null,
  @field:JsonProperty("cookieUrl")
  @param:Optional
  val cookieUrl: String? = null,
  @field:JsonProperty("request")
  @param:Optional
  val request: AffectedRequest? = null,
)
