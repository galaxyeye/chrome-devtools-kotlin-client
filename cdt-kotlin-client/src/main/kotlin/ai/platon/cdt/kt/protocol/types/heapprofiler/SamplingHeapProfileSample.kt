package ai.platon.cdt.kt.protocol.types.heapprofiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * A single sample from a sampling profile.
 */
data class SamplingHeapProfileSample(
  @field:JsonProperty("size")
  val size: Double,
  @field:JsonProperty("nodeId")
  val nodeId: Int,
  @field:JsonProperty("ordinal")
  val ordinal: Double,
)
