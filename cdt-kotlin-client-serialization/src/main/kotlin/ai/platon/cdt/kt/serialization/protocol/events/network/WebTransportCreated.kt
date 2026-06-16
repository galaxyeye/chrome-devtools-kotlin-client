@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired upon WebTransport creation.
 */
@Serializable
data class WebTransportCreated(
  @property:SerialName("transportId")
  val transportId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
