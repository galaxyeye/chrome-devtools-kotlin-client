package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Keyframes Rule
 */
data class KeyframesRule(
  @field:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @field:JsonProperty("keyframes")
  val keyframes: List<KeyframeStyle>,
)
