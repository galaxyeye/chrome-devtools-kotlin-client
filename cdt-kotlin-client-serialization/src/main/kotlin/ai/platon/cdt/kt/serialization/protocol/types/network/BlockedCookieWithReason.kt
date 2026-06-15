@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.collections.List

/**
 * A cookie with was not sent with a request with the corresponding reason.
 */
@Experimental
@Serializable
data class BlockedCookieWithReason(
  @SerialName("blockedReasons")
  val blockedReasons: List<CookieBlockedReason>,
  @SerialName("cookie")
  val cookie: Cookie,
)
