@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * CSS Navigation at-rule descriptor.
 */
@Experimental
data class CSSNavigation(
  @param:JsonProperty("text")
  val text: String,
  @param:JsonProperty("active")
  @param:Optional
  val active: Boolean? = null,
  @param:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
)
