@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallFrame
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 */
@Serializable
data class ProfileNode(
  @SerialName("id")
  val id: Int,
  @SerialName("callFrame")
  val callFrame: CallFrame,
  @SerialName("hitCount")
  @param:Optional
  val hitCount: Int? = null,
  @SerialName("children")
  @param:Optional
  val children: List<Int>? = null,
  @SerialName("deoptReason")
  @param:Optional
  val deoptReason: String? = null,
  @SerialName("positionTicks")
  @param:Optional
  val positionTicks: List<PositionTickInfo>? = null,
)
