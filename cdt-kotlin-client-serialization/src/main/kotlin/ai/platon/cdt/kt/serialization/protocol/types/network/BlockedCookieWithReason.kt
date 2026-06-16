@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cookie with was not sent with a request with the corresponding reason.
 */
@Serializable
@Experimental
data class BlockedCookieWithReason(
  @property:SerialName("blockedReasons")
  val blockedReasons: List<CookieBlockedReason>,
  @property:SerialName("cookie")
  val cookie: Cookie,
)
