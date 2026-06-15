@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.Initiator
import kotlin.Double
import kotlin.String

/**
 * Fired upon WebTransport creation.
 */
@Serializable
data class WebTransportCreated(
  @SerialName("transportId")
  val transportId: String,
  @SerialName("url")
  val url: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("initiator")
  @param:Optional
  val initiator: Initiator? = null,
)
