@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Notifies that an AudioNode is disconnected to an AudioParam.
 */
@Serializable
data class NodeParamDisconnected(
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("sourceId")
  val sourceId: String,
  @property:SerialName("destinationId")
  val destinationId: String,
  @property:SerialName("sourceOutputIndex")
  @param:Optional
  val sourceOutputIndex: Double? = null,
)
