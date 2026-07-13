@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.animation

import ai.platon.cdt.kt.protocol.types.animation.Animation
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Event for animation that has been updated.
 */
data class AnimationUpdated(
  @param:JsonProperty("animation")
  val animation: Animation,
)
