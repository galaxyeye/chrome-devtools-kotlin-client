@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A descriptor of operation to mutate style declaration text.
 */
@Serializable
data class StyleDeclarationEdit(
  @property:SerialName("styleSheetId")
  val styleSheetId: String,
  @property:SerialName("range")
  val range: SourceRange,
  @property:SerialName("text")
  val text: String,
)
