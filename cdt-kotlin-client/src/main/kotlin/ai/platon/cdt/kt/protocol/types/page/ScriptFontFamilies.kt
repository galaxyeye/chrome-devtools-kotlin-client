@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Font families collection for a script.
 */
@Experimental
data class ScriptFontFamilies(
  @param:JsonProperty("script")
  val script: String,
  @param:JsonProperty("fontFamilies")
  val fontFamilies: FontFamilies,
)
