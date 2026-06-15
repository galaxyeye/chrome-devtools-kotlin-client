@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.animation.Animation

/**
 * Event for animation that has been started.
 */
@Serializable
data class AnimationStarted(
  @SerialName("animation")
  val animation: Animation,
)
