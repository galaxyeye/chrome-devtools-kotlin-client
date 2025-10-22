package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Heap profile sample.
 */
public data class SamplingProfileNode(
  @field:JsonProperty("size")
  public val size: Double,
  @field:JsonProperty("total")
  public val total: Double,
  @field:JsonProperty("stack")
  public val stack: List<String>,
)
