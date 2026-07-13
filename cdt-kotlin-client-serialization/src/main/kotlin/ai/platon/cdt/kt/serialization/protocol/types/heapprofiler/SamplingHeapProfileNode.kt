@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler

import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallFrame
import kotlin.Double
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sampling Heap Profile node. Holds callsite information, allocation statistics and child nodes.
 */
@Serializable
data class SamplingHeapProfileNode(
  @property:SerialName("callFrame")
  val callFrame: CallFrame,
  @property:SerialName("selfSize")
  val selfSize: Double,
  @property:SerialName("id")
  val id: Int,
  @property:SerialName("children")
  val children: List<SamplingHeapProfileNode>,
)
