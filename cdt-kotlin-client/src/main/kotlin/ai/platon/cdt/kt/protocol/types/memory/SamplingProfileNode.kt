package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Heap profile sample.
 */
data class SamplingProfileNode(
  @field:JsonProperty("size")
  val size: Double,
  @field:JsonProperty("total")
  val total: Double,
  @field:JsonProperty("stack")
  val stack: List<String>,
)
