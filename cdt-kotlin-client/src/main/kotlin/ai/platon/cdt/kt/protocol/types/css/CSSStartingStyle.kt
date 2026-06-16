@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS Starting Style at-rule descriptor.
 */
@Experimental
data class CSSStartingStyle(
  @param:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
  @param:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
)
