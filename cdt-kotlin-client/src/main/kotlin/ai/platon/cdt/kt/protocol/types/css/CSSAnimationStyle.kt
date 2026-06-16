@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS style coming from animations with the name of the animation.
 */
data class CSSAnimationStyle(
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @param:JsonProperty("style")
  val style: CSSStyle,
)
