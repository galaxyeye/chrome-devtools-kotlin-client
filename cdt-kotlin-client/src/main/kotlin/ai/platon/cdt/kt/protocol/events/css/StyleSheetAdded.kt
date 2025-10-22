package ai.platon.cdt.kt.protocol.events.css

import ai.platon.cdt.kt.protocol.types.css.CSSStyleSheetHeader
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Fired whenever an active document stylesheet is added.
 */
data class StyleSheetAdded(
  @field:JsonProperty("header")
  val `header`: CSSStyleSheetHeader,
)
