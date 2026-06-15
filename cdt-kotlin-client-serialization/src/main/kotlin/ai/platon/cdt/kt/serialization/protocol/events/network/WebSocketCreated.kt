@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.String

/**
 * Fired upon WebSocket creation.
 */
@Serializable
data class WebSocketCreated(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("url")
  val url: String,
  @SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
