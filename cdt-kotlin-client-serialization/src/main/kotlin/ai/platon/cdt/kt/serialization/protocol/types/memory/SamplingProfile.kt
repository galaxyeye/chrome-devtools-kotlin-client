@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Array of heap profile samples.
 */
@Serializable
data class SamplingProfile(
  @property:SerialName("samples")
  val samples: List<SamplingProfileNode>,
  @property:SerialName("modules")
  val modules: List<Module>,
)
