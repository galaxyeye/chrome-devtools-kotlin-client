@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Inherited CSS style collection for animated styles from ancestor node.
 */
@Serializable
data class InheritedAnimatedStyleEntry(
  @property:SerialName("animationStyles")
  @param:Optional
  val animationStyles: List<CSSAnimationStyle>? = null,
  @property:SerialName("transitionsStyle")
  @param:Optional
  val transitionsStyle: CSSStyle? = null,
)
