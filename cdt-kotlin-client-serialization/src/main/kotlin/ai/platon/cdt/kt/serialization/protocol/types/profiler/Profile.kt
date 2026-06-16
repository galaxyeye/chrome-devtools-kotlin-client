@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Profile.
 */
@Serializable
data class Profile(
  @property:SerialName("nodes")
  val nodes: List<ProfileNode>,
  @property:SerialName("startTime")
  val startTime: Double,
  @property:SerialName("endTime")
  val endTime: Double,
  @property:SerialName("samples")
  @param:Optional
  val samples: List<Int>? = null,
  @property:SerialName("timeDeltas")
  @param:Optional
  val timeDeltas: List<Int>? = null,
)
