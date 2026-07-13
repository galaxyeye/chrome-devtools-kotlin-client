@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS style coming from animations with the name of the animation.
 */
@Serializable
data class CSSAnimationStyle(
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("style")
  val style: CSSStyle,
)
