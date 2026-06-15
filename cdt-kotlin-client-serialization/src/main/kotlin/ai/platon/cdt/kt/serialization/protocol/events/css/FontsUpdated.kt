@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.css.FontFace

/**
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
 * web font
 */
@Serializable
data class FontsUpdated(
  @SerialName("font")
  @param:Optional
  val font: FontFace? = null,
)
