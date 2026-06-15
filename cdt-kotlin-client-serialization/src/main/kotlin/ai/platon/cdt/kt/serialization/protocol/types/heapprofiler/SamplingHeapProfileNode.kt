@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallFrame
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */
@Serializable
data class SamplingHeapProfileNode(
  @SerialName("callFrame")
  val callFrame: CallFrame,
  @SerialName("selfSize")
  val selfSize: Double,
  @SerialName("id")
  val id: Int,
  @SerialName("children")
  val children: List<SamplingHeapProfileNode>,
)
