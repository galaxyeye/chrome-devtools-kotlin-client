@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * CSS @position-try rule representation.
 */
data class CSSPositionTryRule(
  @param:JsonProperty("name")
  val name: Value,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @param:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @param:JsonProperty("style")
  val style: CSSStyle,
  @param:JsonProperty("active")
  val active: Boolean,
)
