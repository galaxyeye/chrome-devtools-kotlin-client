@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A cookie should have been blocked by 3PCD but is exempted and stored from a response with the
 * corresponding reason. A cookie could only have at most one exemption reason.
 */
@Experimental
data class ExemptedSetCookieWithReason(
  @param:JsonProperty("exemptionReason")
  val exemptionReason: CookieExemptionReason,
  @param:JsonProperty("cookieLine")
  val cookieLine: String,
  @param:JsonProperty("cookie")
  val cookie: Cookie,
)
