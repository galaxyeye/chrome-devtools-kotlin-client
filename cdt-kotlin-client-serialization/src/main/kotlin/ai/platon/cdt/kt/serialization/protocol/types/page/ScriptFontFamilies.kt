@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Font families collection for a script.
 */
@Serializable
@Experimental
data class ScriptFontFamilies(
  @property:SerialName("script")
  val script: String,
  @property:SerialName("fontFamilies")
  val fontFamilies: FontFamilies,
)
