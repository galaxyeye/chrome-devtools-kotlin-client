@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * AnimationEffect instance
 */
@Serializable
data class AnimationEffect(
  @property:SerialName("delay")
  val delay: Double,
  @property:SerialName("endDelay")
  val endDelay: Double,
  @property:SerialName("iterationStart")
  val iterationStart: Double,
  @property:SerialName("iterations")
  @param:Optional
  val iterations: Double? = null,
  @property:SerialName("duration")
  val duration: Double,
  @property:SerialName("direction")
  val direction: String,
  @property:SerialName("fill")
  val fill: String,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @property:SerialName("keyframesRule")
  @param:Optional
  val keyframesRule: KeyframesRule? = null,
  @property:SerialName("easing")
  val easing: String,
)
