@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.SignedExchangeInfo
import kotlin.String

/**
 * Fired when a signed exchange was received over the network
 */
@Experimental
@Serializable
data class SignedExchangeReceived(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("info")
  val info: SignedExchangeInfo,
)
