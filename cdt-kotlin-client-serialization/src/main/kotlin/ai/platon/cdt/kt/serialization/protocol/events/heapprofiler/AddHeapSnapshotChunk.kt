@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddHeapSnapshotChunk(
  @property:SerialName("chunk")
  val chunk: String,
)
