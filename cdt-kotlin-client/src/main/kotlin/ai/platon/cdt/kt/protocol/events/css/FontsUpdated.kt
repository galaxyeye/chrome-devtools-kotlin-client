package ai.platon.cdt.kt.protocol.events.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.css.FontFace
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Fires whenever a web font is updated.  A non-empty font parameter indicates a successfully loaded
 * web font
 */
data class FontsUpdated(
  @field:JsonProperty("font")
  @param:Optional
  val font: FontFace? = null,
)
