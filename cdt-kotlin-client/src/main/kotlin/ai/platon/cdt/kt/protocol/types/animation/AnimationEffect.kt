package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * AnimationEffect instance
 */
public data class AnimationEffect(
  @field:JsonProperty("delay")
  public val delay: Double,
  @field:JsonProperty("endDelay")
  public val endDelay: Double,
  @field:JsonProperty("iterationStart")
  public val iterationStart: Double,
  @field:JsonProperty("iterations")
  public val iterations: Double,
  @field:JsonProperty("duration")
  public val duration: Double,
  @field:JsonProperty("direction")
  public val direction: String,
  @field:JsonProperty("fill")
  public val fill: String,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  public val backendNodeId: Int? = null,
  @field:JsonProperty("keyframesRule")
  @param:Optional
  public val keyframesRule: KeyframesRule? = null,
  @field:JsonProperty("easing")
  public val easing: String,
)
