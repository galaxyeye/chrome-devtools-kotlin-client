@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * This information is currently necessary, as the front-end has a difficult
 * time finding a specific cookie. With this, we can convey specific error
 * information without the cookie.
 */
@Serializable
data class SameSiteCookieIssueDetails(
  @SerialName("cookie")
  val cookie: AffectedCookie,
  @SerialName("cookieWarningReasons")
  val cookieWarningReasons: List<SameSiteCookieWarningReason>,
  @SerialName("cookieExclusionReasons")
  val cookieExclusionReasons: List<SameSiteCookieExclusionReason>,
  @SerialName("operation")
  val operation: SameSiteCookieOperation,
  @SerialName("siteForCookies")
  @param:Optional
  val siteForCookies: String? = null,
  @SerialName("cookieUrl")
  @param:Optional
  val cookieUrl: String? = null,
  @SerialName("request")
  @param:Optional
  val request: AffectedRequest? = null,
)
