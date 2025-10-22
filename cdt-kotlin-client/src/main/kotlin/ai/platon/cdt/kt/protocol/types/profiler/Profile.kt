package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Profile.
 */
public data class Profile(
  @field:JsonProperty("nodes")
  public val nodes: List<ProfileNode>,
  @field:JsonProperty("startTime")
  public val startTime: Double,
  @field:JsonProperty("endTime")
  public val endTime: Double,
  @field:JsonProperty("samples")
  @param:Optional
  public val samples: List<Int>? = null,
  @field:JsonProperty("timeDeltas")
  @param:Optional
  public val timeDeltas: List<Int>? = null,
)
