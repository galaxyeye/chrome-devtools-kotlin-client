package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

public data class DOMCounters(
  @field:JsonProperty("documents")
  public val documents: Int,
  @field:JsonProperty("nodes")
  public val nodes: Int,
  @field:JsonProperty("jsEventListeners")
  public val jsEventListeners: Int,
)
