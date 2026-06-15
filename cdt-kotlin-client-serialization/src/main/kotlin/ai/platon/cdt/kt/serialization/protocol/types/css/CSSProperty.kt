@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

/**
 * CSS property declaration data.
 */
@Serializable
data class CSSProperty(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
  @SerialName("important")
  @param:Optional
  val important: Boolean? = null,
  @SerialName("implicit")
  @param:Optional
  val implicit: Boolean? = null,
  @SerialName("text")
  @param:Optional
  val text: String? = null,
  @SerialName("parsedOk")
  @param:Optional
  val parsedOk: Boolean? = null,
  @SerialName("disabled")
  @param:Optional
  val disabled: Boolean? = null,
  @SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
)
