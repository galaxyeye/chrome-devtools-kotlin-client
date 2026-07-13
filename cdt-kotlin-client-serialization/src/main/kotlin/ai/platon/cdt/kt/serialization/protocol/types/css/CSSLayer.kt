@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS Layer at-rule descriptor.
 */
@Serializable
@Experimental
data class CSSLayer(
  @property:SerialName("text")
  val text: String,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
)
