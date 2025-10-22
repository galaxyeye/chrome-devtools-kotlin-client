package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * AnimationEffect instance
 */
data class AnimationEffect(
  @field:JsonProperty("delay")
  val delay: Double,
  @field:JsonProperty("endDelay")
  val endDelay: Double,
  @field:JsonProperty("iterationStart")
  val iterationStart: Double,
  @field:JsonProperty("iterations")
  val iterations: Double,
  @field:JsonProperty("duration")
  val duration: Double,
  @field:JsonProperty("direction")
  val direction: String,
  @field:JsonProperty("fill")
  val fill: String,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @field:JsonProperty("keyframesRule")
  @param:Optional
  val keyframesRule: KeyframesRule? = null,
  @field:JsonProperty("easing")
  val easing: String,
)
