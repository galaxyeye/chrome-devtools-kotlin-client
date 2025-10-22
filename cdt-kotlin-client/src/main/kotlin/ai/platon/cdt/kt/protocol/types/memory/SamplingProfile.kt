package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Array of heap profile samples.
 */
data class SamplingProfile(
  @field:JsonProperty("samples")
  val samples: List<SamplingProfileNode>,
  @field:JsonProperty("modules")
  val modules: List<Module>,
)
