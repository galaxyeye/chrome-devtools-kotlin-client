@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sampling profile.
 */
@Serializable
data class SamplingHeapProfile(
  @property:SerialName("head")
  val head: SamplingHeapProfileNode,
  @property:SerialName("samples")
  val samples: List<SamplingHeapProfileSample>,
)
