@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A cookie which was not stored from a response with the corresponding reason.
 */
@Serializable
@Experimental
data class BlockedSetCookieWithReason(
  @property:SerialName("blockedReasons")
  val blockedReasons: List<SetCookieBlockedReason>,
  @property:SerialName("cookieLine")
  val cookieLine: String,
  @property:SerialName("cookie")
  @param:Optional
  val cookie: Cookie? = null,
)
