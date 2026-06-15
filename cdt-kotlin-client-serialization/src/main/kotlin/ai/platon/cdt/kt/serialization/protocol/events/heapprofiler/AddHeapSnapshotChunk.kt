@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class AddHeapSnapshotChunk(
  @SerialName("chunk")
  val chunk: String,
)
