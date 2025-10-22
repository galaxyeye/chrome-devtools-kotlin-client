package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Array of heap profile samples.
 */
public data class SamplingProfile(
  @field:JsonProperty("samples")
  public val samples: List<SamplingProfileNode>,
  @field:JsonProperty("modules")
  public val modules: List<Module>,
)
