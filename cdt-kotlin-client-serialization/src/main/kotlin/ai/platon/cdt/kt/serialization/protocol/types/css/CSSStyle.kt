@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS style representation.
 */
@Serializable
data class CSSStyle(
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("cssProperties")
  val cssProperties: List<CSSProperty>,
  @property:SerialName("shorthandEntries")
  val shorthandEntries: List<ShorthandEntry>,
  @property:SerialName("cssText")
  @param:Optional
  val cssText: String? = null,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
)
