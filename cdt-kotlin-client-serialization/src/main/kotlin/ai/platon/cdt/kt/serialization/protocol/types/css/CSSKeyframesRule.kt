@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

/**
 * CSS keyframes rule representation.
 */
@Serializable
data class CSSKeyframesRule(
  @SerialName("animationName")
  val animationName: Value,
  @SerialName("keyframes")
  val keyframes: List<CSSKeyframeRule>,
)
