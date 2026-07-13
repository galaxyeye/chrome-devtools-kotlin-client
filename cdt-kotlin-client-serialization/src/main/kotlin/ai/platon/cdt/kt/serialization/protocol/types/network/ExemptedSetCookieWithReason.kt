@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cookie should have been blocked by 3PCD but is exempted and stored from a response with the
 * corresponding reason. A cookie could only have at most one exemption reason.
 */
@Serializable
@Experimental
data class ExemptedSetCookieWithReason(
  @property:SerialName("exemptionReason")
  val exemptionReason: CookieExemptionReason,
  @property:SerialName("cookieLine")
  val cookieLine: String,
  @property:SerialName("cookie")
  val cookie: Cookie,
)
