package ai.platon.cdt.kt.protocol.types.heapprofiler

import ai.platon.cdt.kt.protocol.types.runtime.CallFrame
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */
public data class SamplingHeapProfileNode(
  @field:JsonProperty("callFrame")
  public val callFrame: CallFrame,
  @field:JsonProperty("selfSize")
  public val selfSize: Double,
  @field:JsonProperty("id")
  public val id: Int,
  @field:JsonProperty("children")
  public val children: List<SamplingHeapProfileNode>,
)
