@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for each animation that has been created.
 */
@Serializable
data class AnimationCreated(
  @property:SerialName("id")
  val id: String,
)
