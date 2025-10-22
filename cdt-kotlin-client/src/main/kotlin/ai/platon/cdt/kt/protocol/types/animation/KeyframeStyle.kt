package ai.platon.cdt.kt.protocol.types.animation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Keyframe Style
 */
public data class KeyframeStyle(
  @field:JsonProperty("offset")
  public val offset: String,
  @field:JsonProperty("easing")
  public val easing: String,
)
