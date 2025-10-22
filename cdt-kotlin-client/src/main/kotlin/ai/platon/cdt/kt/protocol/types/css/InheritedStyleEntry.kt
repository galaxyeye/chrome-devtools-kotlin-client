package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Inherited CSS rule collection from ancestor node.
 */
public data class InheritedStyleEntry(
  @field:JsonProperty("inlineStyle")
  @param:Optional
  public val inlineStyle: CSSStyle? = null,
  @field:JsonProperty("matchedCSSRules")
  public val matchedCSSRules: List<RuleMatch>,
)
