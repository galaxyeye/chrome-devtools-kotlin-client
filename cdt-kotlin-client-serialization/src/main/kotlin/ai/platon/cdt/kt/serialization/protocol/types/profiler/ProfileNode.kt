@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallFrame
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 */
@Serializable
data class ProfileNode(
  @property:SerialName("id")
  val id: Int,
  @property:SerialName("callFrame")
  val callFrame: CallFrame,
  @property:SerialName("hitCount")
  @param:Optional
  val hitCount: Int? = null,
  @property:SerialName("children")
  @param:Optional
  val children: List<Int>? = null,
  @property:SerialName("deoptReason")
  @param:Optional
  val deoptReason: String? = null,
  @property:SerialName("positionTicks")
  @param:Optional
  val positionTicks: List<PositionTickInfo>? = null,
)
