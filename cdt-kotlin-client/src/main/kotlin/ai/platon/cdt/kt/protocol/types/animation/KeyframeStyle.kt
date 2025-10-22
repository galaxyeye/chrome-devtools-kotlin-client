package ai.platon.cdt.kt.protocol.types.animation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Keyframe Style
 */
data class KeyframeStyle(
  @field:JsonProperty("offset")
  val offset: String,
  @field:JsonProperty("easing")
  val easing: String,
)
