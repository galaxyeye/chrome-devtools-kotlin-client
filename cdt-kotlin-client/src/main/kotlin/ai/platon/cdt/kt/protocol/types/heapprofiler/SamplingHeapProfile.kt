package ai.platon.cdt.kt.protocol.types.heapprofiler

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Sampling profile.
 */
public data class SamplingHeapProfile(
  @field:JsonProperty("head")
  public val head: SamplingHeapProfileNode,
  @field:JsonProperty("samples")
  public val samples: List<SamplingHeapProfileSample>,
)
