@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Keyframe Style
 */
@Serializable
data class KeyframeStyle(
  @property:SerialName("offset")
  val offset: String,
  @property:SerialName("easing")
  val easing: String,
)
