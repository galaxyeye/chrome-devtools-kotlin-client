package ai.platon.cdt.kt.protocol.events.heapprofiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class AddHeapSnapshotChunk(
  @field:JsonProperty("chunk")
  val chunk: String,
)
