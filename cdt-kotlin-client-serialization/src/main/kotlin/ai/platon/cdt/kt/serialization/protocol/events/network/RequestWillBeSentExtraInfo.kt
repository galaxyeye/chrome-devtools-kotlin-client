@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.BlockedCookieWithReason
import ai.platon.cdt.kt.serialization.protocol.types.network.ClientSecurityState
import kotlin.Any
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
@Serializable
data class RequestWillBeSentExtraInfo(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("associatedCookies")
  val associatedCookies: List<BlockedCookieWithReason>,
  @SerialName("headers")
  val headers: Map<String, Any?>,
  @SerialName("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
)
