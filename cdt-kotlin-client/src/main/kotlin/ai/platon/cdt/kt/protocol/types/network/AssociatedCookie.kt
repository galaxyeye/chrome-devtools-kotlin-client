@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * A cookie associated with the request which may or may not be sent with it.
 * Includes the cookies itself and reasons for blocking or exemption.
 */
@Experimental
data class AssociatedCookie(
  @param:JsonProperty("cookie")
  val cookie: Cookie,
  @param:JsonProperty("blockedReasons")
  val blockedReasons: List<CookieBlockedReason>,
  @param:JsonProperty("exemptionReason")
  @param:Optional
  val exemptionReason: CookieExemptionReason? = null,
)
