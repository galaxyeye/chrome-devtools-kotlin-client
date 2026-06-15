@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

/**
 * Inherited CSS rule collection from ancestor node.
 */
@Serializable
data class InheritedStyleEntry(
  @SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @SerialName("matchedCSSRules")
  val matchedCSSRules: List<RuleMatch>,
)
