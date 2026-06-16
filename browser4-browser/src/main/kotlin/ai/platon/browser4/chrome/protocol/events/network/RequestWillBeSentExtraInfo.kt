@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.AssociatedCookie
import ai.platon.browser4.chrome.protocol.types.network.ClientSecurityState
import ai.platon.browser4.chrome.protocol.types.network.ConnectTiming
import ai.platon.browser4.chrome.protocol.types.network.DeviceBoundSessionWithUsage
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Fired when additional information about a requestWillBeSent event is available from the
 * network stack. Not every requestWillBeSent event will have an additional
 * requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
 * or requestWillBeSentExtraInfo will be fired first for the same request.
 */
@Serializable
@Experimental
data class RequestWillBeSentExtraInfo(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("associatedCookies")
  val associatedCookies: List<AssociatedCookie>,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("connectTiming")
  @param:Experimental
  val connectTiming: ConnectTiming,
  @property:SerialName("deviceBoundSessionUsages")
  @param:Optional
  val deviceBoundSessionUsages: List<DeviceBoundSessionWithUsage>? = null,
  @property:SerialName("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
  @property:SerialName("siteHasCookieInOtherPartition")
  @param:Optional
  val siteHasCookieInOtherPartition: Boolean? = null,
  @property:SerialName("appliedNetworkConditionsId")
  @param:Optional
  val appliedNetworkConditionsId: String? = null,
)
