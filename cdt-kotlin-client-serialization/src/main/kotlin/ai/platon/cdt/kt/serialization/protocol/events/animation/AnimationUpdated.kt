@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation

import ai.platon.cdt.kt.serialization.protocol.types.animation.Animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for animation that has been updated.
 */
@Serializable
data class AnimationUpdated(
  @property:SerialName("animation")
  val animation: Animation,
)
