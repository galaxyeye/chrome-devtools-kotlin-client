@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Event for each animation that has been created.
 */
@Serializable
data class AnimationCreated(
  @SerialName("id")
  val id: String,
)
