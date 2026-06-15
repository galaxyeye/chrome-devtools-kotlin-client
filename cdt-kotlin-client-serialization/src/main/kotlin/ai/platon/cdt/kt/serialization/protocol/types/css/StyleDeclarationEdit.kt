@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * A descriptor of operation to mutate style declaration text.
 */
@Serializable
data class StyleDeclarationEdit(
  @SerialName("styleSheetId")
  val styleSheetId: String,
  @SerialName("range")
  val range: SourceRange,
  @SerialName("text")
  val text: String,
)
