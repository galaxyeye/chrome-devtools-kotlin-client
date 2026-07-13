@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cookie associated with the request which may or may not be sent with it.
 * Includes the cookies itself and reasons for blocking or exemption.
 */
@Serializable
@Experimental
data class AssociatedCookie(
  @property:SerialName("cookie")
  val cookie: Cookie,
  @property:SerialName("blockedReasons")
  val blockedReasons: List<CookieBlockedReason>,
  @property:SerialName("exemptionReason")
  @param:Optional
  val exemptionReason: CookieExemptionReason? = null,
)
