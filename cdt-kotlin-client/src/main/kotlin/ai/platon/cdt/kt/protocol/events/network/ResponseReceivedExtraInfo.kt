@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.BlockedSetCookieWithReason
import ai.platon.cdt.kt.protocol.types.network.CookiePartitionKey
import ai.platon.cdt.kt.protocol.types.network.ExemptedSetCookieWithReason
import ai.platon.cdt.kt.protocol.types.network.IPAddressSpace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
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
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("blockedCookies")
  val blockedCookies: List<BlockedSetCookieWithReason>,
  @param:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @param:JsonProperty("resourceIPAddressSpace")
  val resourceIPAddressSpace: IPAddressSpace,
  @param:JsonProperty("statusCode")
  val statusCode: Int,
  @param:JsonProperty("headersText")
  @param:Optional
  val headersText: String? = null,
  @param:JsonProperty("cookiePartitionKey")
  @param:Optional
  @param:Experimental
  val cookiePartitionKey: CookiePartitionKey? = null,
  @param:JsonProperty("cookiePartitionKeyOpaque")
  @param:Optional
  val cookiePartitionKeyOpaque: Boolean? = null,
  @param:JsonProperty("exemptedCookies")
  @param:Optional
  val exemptedCookies: List<ExemptedSetCookieWithReason>? = null,
)
