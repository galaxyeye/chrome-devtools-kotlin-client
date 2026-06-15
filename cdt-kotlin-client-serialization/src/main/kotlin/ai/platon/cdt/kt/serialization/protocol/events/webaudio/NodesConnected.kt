@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

/**
 * Notifies that two AudioNodes are connected.
 */
@Serializable
data class NodesConnected(
  @SerialName("contextId")
  val contextId: String,
  @SerialName("sourceId")
  val sourceId: String,
  @SerialName("destinationId")
  val destinationId: String,
  @SerialName("sourceOutputIndex")
  @param:Optional
  val sourceOutputIndex: Double? = null,
  @SerialName("destinationInputIndex")
  @param:Optional
  val destinationInputIndex: Double? = null,
)
