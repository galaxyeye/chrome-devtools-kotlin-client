@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

/**
 * Sampling profile.
 */
@Serializable
data class SamplingHeapProfile(
  @SerialName("head")
  val head: SamplingHeapProfileNode,
  @SerialName("samples")
  val samples: List<SamplingHeapProfileSample>,
)
