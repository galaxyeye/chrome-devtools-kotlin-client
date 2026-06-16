@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Inherited CSS style collection for animated styles from ancestor node.
 */
data class InheritedAnimatedStyleEntry(
  @param:JsonProperty("animationStyles")
  @param:Optional
  val animationStyles: List<CSSAnimationStyle>? = null,
  @param:JsonProperty("transitionsStyle")
  @param:Optional
  val transitionsStyle: CSSStyle? = null,
)
