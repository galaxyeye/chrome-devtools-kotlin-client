@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.css.CSSStyleSheetHeader

/**
 * Fired whenever an active document stylesheet is added.
 */
@Serializable
data class StyleSheetAdded(
  @SerialName("header")
  val `header`: CSSStyleSheetHeader,
)
