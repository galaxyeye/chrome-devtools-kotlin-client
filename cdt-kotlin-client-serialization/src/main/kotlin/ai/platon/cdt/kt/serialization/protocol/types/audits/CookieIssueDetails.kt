@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This information is currently necessary, as the front-end has a difficult
 * time finding a specific cookie. With this, we can convey specific error
 * information without the cookie.
 */
@Serializable
data class CookieIssueDetails(
  @property:SerialName("cookie")
  @param:Optional
  val cookie: AffectedCookie? = null,
  @property:SerialName("rawCookieLine")
  @param:Optional
  val rawCookieLine: String? = null,
  @property:SerialName("cookieWarningReasons")
  val cookieWarningReasons: List<CookieWarningReason>,
  @property:SerialName("cookieExclusionReasons")
  val cookieExclusionReasons: List<CookieExclusionReason>,
  @property:SerialName("operation")
  val operation: CookieOperation,
  @property:SerialName("siteForCookies")
  @param:Optional
  val siteForCookies: String? = null,
  @property:SerialName("cookieUrl")
  @param:Optional
  val cookieUrl: String? = null,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
  @property:SerialName("insight")
  @param:Optional
  val insight: CookieIssueInsight? = null,
)
