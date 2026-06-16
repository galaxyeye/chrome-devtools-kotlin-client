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
data class SameSiteCookieIssueDetails(
  @property:SerialName("cookie")
  val cookie: AffectedCookie,
  @property:SerialName("cookieWarningReasons")
  val cookieWarningReasons: List<SameSiteCookieWarningReason>,
  @property:SerialName("cookieExclusionReasons")
  val cookieExclusionReasons: List<SameSiteCookieExclusionReason>,
  @property:SerialName("operation")
  val operation: SameSiteCookieOperation,
  @property:SerialName("siteForCookies")
  @param:Optional
  val siteForCookies: String? = null,
  @property:SerialName("cookieUrl")
  @param:Optional
  val cookieUrl: String? = null,
  @property:SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
)
