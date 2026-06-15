@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

/**
 * Array of heap profile samples.
 */
@Serializable
data class SamplingProfile(
  @SerialName("samples")
  val samples: List<SamplingProfileNode>,
  @SerialName("modules")
  val modules: List<Module>,
)
