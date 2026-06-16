@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.SignedExchangeInfo
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a signed exchange was received over the network
 */
@Serializable
@Experimental
data class SignedExchangeReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("info")
  val info: SignedExchangeInfo,
)
