@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.AssociatedCookie
import ai.platon.cdt.kt.protocol.types.network.ClientSecurityState
import ai.platon.cdt.kt.protocol.types.network.ConnectTiming
import ai.platon.cdt.kt.protocol.types.network.DeviceBoundSessionWithUsage
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Fired when additional information about a requestWillBeSent event is available from the
 * network stack. Not every requestWillBeSent event will have an additional
 * requestWillBeSentExtraInfo fired for it, and there is no guarantee whether requestWillBeSent
 * or requestWillBeSentExtraInfo will be fired first for the same request.
 */
@Experimental
data class RequestWillBeSentExtraInfo(
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("associatedCookies")
  val associatedCookies: List<AssociatedCookie>,
  @param:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @param:JsonProperty("connectTiming")
  @param:Experimental
  val connectTiming: ConnectTiming,
  @param:JsonProperty("deviceBoundSessionUsages")
  @param:Optional
  val deviceBoundSessionUsages: List<DeviceBoundSessionWithUsage>? = null,
  @param:JsonProperty("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
  @param:JsonProperty("siteHasCookieInOtherPartition")
  @param:Optional
  val siteHasCookieInOtherPartition: Boolean? = null,
  @param:JsonProperty("appliedNetworkConditionsId")
  @param:Optional
  val appliedNetworkConditionsId: String? = null,
)
