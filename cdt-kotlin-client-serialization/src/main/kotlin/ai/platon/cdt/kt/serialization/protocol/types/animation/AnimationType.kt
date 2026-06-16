@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Animation type of `Animation`.
 */
@Serializable
public enum class AnimationType {
  @SerialName("CSSTransition")
  CSS_TRANSITION,
  @SerialName("CSSAnimation")
  CSS_ANIMATION,
  @SerialName("WebAnimation")
  WEB_ANIMATION,
  UNKNOWN,
}
