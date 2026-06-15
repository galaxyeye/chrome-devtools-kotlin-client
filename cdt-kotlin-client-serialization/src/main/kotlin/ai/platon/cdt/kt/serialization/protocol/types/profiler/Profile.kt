@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Profile.
 */
@Serializable
data class Profile(
  @SerialName("nodes")
  val nodes: List<ProfileNode>,
  @SerialName("startTime")
  val startTime: Double,
  @SerialName("endTime")
  val endTime: Double,
  @SerialName("samples")
  @param:Optional
  val samples: List<Int>? = null,
  @SerialName("timeDeltas")
  @param:Optional
  val timeDeltas: List<Int>? = null,
)
