@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when data is sent to tcp direct socket stream.
 */
@Serializable
@Experimental
data class DirectTCPSocketChunkSent(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
