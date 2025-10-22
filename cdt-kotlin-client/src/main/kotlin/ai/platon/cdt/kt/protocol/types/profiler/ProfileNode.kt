package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.CallFrame
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Profile node. Holds callsite information, execution statistics and child nodes.
 */
public data class ProfileNode(
  @field:JsonProperty("id")
  public val id: Int,
  @field:JsonProperty("callFrame")
  public val callFrame: CallFrame,
  @field:JsonProperty("hitCount")
  @param:Optional
  public val hitCount: Int? = null,
  @field:JsonProperty("children")
  @param:Optional
  public val children: List<Int>? = null,
  @field:JsonProperty("deoptReason")
  @param:Optional
  public val deoptReason: String? = null,
  @field:JsonProperty("positionTicks")
  @param:Optional
  public val positionTicks: List<PositionTickInfo>? = null,
)
