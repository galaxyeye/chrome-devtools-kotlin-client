package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class DOMCounters(
  @field:JsonProperty("documents")
  val documents: Int,
  @field:JsonProperty("nodes")
  val nodes: Int,
  @field:JsonProperty("jsEventListeners")
  val jsEventListeners: Int,
)
