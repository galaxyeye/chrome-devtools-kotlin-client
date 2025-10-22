package ai.platon.cdt.kt.protocol.events.heapprofiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class AddHeapSnapshotChunk(
  @field:JsonProperty("chunk")
  public val chunk: String,
)
