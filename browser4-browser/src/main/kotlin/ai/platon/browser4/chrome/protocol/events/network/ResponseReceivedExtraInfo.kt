@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.BlockedSetCookieWithReason
import ai.platon.browser4.chrome.protocol.types.network.CookiePartitionKey
import ai.platon.browser4.chrome.protocol.types.network.ExemptedSetCookieWithReason
import ai.platon.browser4.chrome.protocol.types.network.IPAddressSpace
import kotlin.Boolean
import kotlin.Int
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
  @property:SerialName("statusCode")
  val statusCode: Int,
  @property:SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
  @property:SerialName("cookiePartitionKey")
  @param:Optional
  @param:Experimental
  val cookiePartitionKey: CookiePartitionKey? = null,
  @property:SerialName("cookiePartitionKeyOpaque")
  @param:Optional
  val cookiePartitionKeyOpaque: Boolean? = null,
  @property:SerialName("exemptedCookies")
  @param:Optional
  val exemptedCookies: List<ExemptedSetCookieWithReason>? = null,
)
