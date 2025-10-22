package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.BlockedSetCookieWithReason
import ai.platon.cdt.kt.protocol.types.network.IPAddressSpace
import com.fasterxml.jackson.`annotation`.JsonProperty
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
data class ResponseReceivedExtraInfo(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("blockedCookies")
  val blockedCookies: List<BlockedSetCookieWithReason>,
  @field:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @field:JsonProperty("resourceIPAddressSpace")
  val resourceIPAddressSpace: IPAddressSpace,
  @field:JsonProperty("headersText")
  @param:Optional
  val headersText: String? = null,
)
