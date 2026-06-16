@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS keyframes rule representation.
 */
@Serializable
data class CSSKeyframesRule(
  @property:SerialName("animationName")
  val animationName: Value,
  @property:SerialName("keyframes")
  val keyframes: List<CSSKeyframeRule>,
)
