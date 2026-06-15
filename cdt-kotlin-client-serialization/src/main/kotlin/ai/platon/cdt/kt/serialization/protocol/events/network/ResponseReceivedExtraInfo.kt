@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.BlockedSetCookieWithReason
import ai.platon.cdt.kt.serialization.protocol.types.network.IPAddressSpace
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Fired when additional information about a responseReceived event is available from the network
 * stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
 * it, and responseReceivedExtraInfo may be fired before or after responseReceived.
 */
@Experimental
@Serializable
data class ResponseReceivedExtraInfo(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("blockedCookies")
  val blockedCookies: List<BlockedSetCookieWithReason>,
  @SerialName("headers")
  val headers: Map<String, Any?>,
  @SerialName("resourceIPAddressSpace")
  val resourceIPAddressSpace: IPAddressSpace,
  @SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
)
