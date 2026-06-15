@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * CSS style representation.
 */
@Serializable
data class CSSStyle(
  @SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @SerialName("cssProperties")
  val cssProperties: List<CSSProperty>,
  @SerialName("shorthandEntries")
  val shorthandEntries: List<ShorthandEntry>,
  @SerialName("cssText")
  @param:Optional
  val cssText: String? = null,
  @SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
)
