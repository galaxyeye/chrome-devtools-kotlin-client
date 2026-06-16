@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS generic @rule representation.
 */
data class CSSAtRule(
  @param:JsonProperty("type")
  val type: CSSAtRuleType,
  @param:JsonProperty("subsection")
  @param:Optional
  val subsection: CSSAtRuleSubsection? = null,
  @param:JsonProperty("name")
  @param:Optional
  val name: Value? = null,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @param:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @param:JsonProperty("style")
  val style: CSSStyle,
)
