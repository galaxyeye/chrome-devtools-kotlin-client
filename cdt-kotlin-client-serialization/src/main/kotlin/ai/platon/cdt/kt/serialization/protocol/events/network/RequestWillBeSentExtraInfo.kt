@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.BlockedCookieWithReason
import ai.platon.cdt.kt.serialization.protocol.types.network.ClientSecurityState
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
  val associatedCookies: List<BlockedCookieWithReason>,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
)
