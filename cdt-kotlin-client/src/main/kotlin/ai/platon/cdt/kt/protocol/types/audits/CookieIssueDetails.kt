@file:Suppress("unused")
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
data class CookieIssueDetails(
  @param:JsonProperty("cookie")
  @param:Optional
  val cookie: AffectedCookie? = null,
  @param:JsonProperty("rawCookieLine")
  @param:Optional
  val rawCookieLine: String? = null,
  @param:JsonProperty("cookieWarningReasons")
  val cookieWarningReasons: List<CookieWarningReason>,
  @param:JsonProperty("cookieExclusionReasons")
  val cookieExclusionReasons: List<CookieExclusionReason>,
  @param:JsonProperty("operation")
  val operation: CookieOperation,
  @param:JsonProperty("siteForCookies")
  @param:Optional
  val siteForCookies: String? = null,
  @param:JsonProperty("cookieUrl")
  @param:Optional
  val cookieUrl: String? = null,
  @param:JsonProperty("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @param:JsonProperty("insight")
  @param:Optional
  val insight: CookieIssueInsight? = null,
)
