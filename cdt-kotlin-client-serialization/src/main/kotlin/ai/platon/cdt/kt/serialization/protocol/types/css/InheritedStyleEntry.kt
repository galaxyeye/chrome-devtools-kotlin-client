@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Inherited CSS rule collection from ancestor node.
 */
@Serializable
data class InheritedStyleEntry(
  @property:SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @property:SerialName("matchedCSSRules")
  val matchedCSSRules: List<RuleMatch>,
)
