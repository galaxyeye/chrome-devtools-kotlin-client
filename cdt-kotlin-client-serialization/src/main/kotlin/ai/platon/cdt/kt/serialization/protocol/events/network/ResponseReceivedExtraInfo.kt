@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.BlockedSetCookieWithReason
import ai.platon.cdt.kt.serialization.protocol.types.network.IPAddressSpace
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Fired when additional information about a responseReceived event is available from the network
 * stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
 * it, and responseReceivedExtraInfo may be fired before or after responseReceived.
 */
@Serializable
@Experimental
data class ResponseReceivedExtraInfo(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("blockedCookies")
  val blockedCookies: List<BlockedSetCookieWithReason>,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("resourceIPAddressSpace")
  val resourceIPAddressSpace: IPAddressSpace,
  @property:SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
)
