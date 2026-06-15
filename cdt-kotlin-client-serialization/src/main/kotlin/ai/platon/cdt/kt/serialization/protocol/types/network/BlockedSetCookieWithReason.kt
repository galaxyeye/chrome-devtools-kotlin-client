@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * A cookie which was not stored from a response with the corresponding reason.
 */
@Experimental
@Serializable
data class BlockedSetCookieWithReason(
  @SerialName("blockedReasons")
  val blockedReasons: List<SetCookieBlockedReason>,
  @SerialName("cookieLine")
  val cookieLine: String,
  @SerialName("cookie")
  @param:Optional
  val cookie: Cookie? = null,
)
