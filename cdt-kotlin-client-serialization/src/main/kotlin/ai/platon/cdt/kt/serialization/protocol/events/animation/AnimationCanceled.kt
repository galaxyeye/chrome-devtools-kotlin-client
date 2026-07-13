@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for when an animation has been cancelled.
 */
@Serializable
data class AnimationCanceled(
  @property:SerialName("id")
  val id: String,
)
