package ai.platon.cdt.kt.protocol.types.heapprofiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Sampling profile.
 */
data class SamplingHeapProfile(
  @field:JsonProperty("head")
  val head: SamplingHeapProfileNode,
  @field:JsonProperty("samples")
  val samples: List<SamplingHeapProfileSample>,
)
