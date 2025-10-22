package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Profile.
 */
data class Profile(
  @field:JsonProperty("nodes")
  val nodes: List<ProfileNode>,
  @field:JsonProperty("startTime")
  val startTime: Double,
  @field:JsonProperty("endTime")
  val endTime: Double,
  @field:JsonProperty("samples")
  @param:Optional
  val samples: List<Int>? = null,
  @field:JsonProperty("timeDeltas")
  @param:Optional
  val timeDeltas: List<Int>? = null,
)
