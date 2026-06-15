@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Event for when an animation has been cancelled.
 */
@Serializable
data class AnimationCanceled(
  @SerialName("id")
  val id: String,
)
