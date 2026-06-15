@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * AnimationEffect instance
 */
@Serializable
data class AnimationEffect(
  @SerialName("delay")
  val delay: Double,
  @SerialName("endDelay")
  val endDelay: Double,
  @SerialName("iterationStart")
  val iterationStart: Double,
  @SerialName("iterations")
  val iterations: Double,
  @SerialName("duration")
  val duration: Double,
  @SerialName("direction")
  val direction: String,
  @SerialName("fill")
  val fill: String,
  @SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @SerialName("keyframesRule")
  @param:Optional
  val keyframesRule: KeyframesRule? = null,
  @SerialName("easing")
  val easing: String,
)
