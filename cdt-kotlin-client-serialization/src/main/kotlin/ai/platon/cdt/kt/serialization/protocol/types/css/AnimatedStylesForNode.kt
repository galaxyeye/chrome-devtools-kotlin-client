@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimatedStylesForNode(
  @property:SerialName("animationStyles")
  @param:Optional
  val animationStyles: List<CSSAnimationStyle>? = null,
  @property:SerialName("transitionsStyle")
  @param:Optional
  val transitionsStyle: CSSStyle? = null,
  @property:SerialName("inherited")
  @param:Optional
  val inherited: List<InheritedAnimatedStyleEntry>? = null,
)
