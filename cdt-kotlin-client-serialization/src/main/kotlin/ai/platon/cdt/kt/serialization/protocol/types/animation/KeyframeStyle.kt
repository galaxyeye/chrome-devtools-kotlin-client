@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Keyframe Style
 */
@Serializable
data class KeyframeStyle(
  @SerialName("offset")
  val offset: String,
  @SerialName("easing")
  val easing: String,
)
