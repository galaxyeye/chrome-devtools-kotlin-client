@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired upon WebSocket creation.
 */
@Serializable
data class WebSocketCreated(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
