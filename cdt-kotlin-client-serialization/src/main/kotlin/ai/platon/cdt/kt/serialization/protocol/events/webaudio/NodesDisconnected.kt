@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that AudioNodes are disconnected. The destination can be null, and it means all the outgoing connections from the source are disconnected.
 */
@Serializable
data class NodesDisconnected(
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("sourceId")
  val sourceId: String,
  @property:SerialName("destinationId")
  val destinationId: String,
  @property:SerialName("sourceOutputIndex")
  @param:Optional
  val sourceOutputIndex: Double? = null,
  @property:SerialName("destinationInputIndex")
  @param:Optional
  val destinationInputIndex: Double? = null,
)
