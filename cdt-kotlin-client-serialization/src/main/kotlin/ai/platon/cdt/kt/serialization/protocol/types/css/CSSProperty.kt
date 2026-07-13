@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS property declaration data.
 */
@Serializable
data class CSSProperty(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
  @property:SerialName("important")
  @param:Optional
  val important: Boolean? = null,
  @property:SerialName("implicit")
  @param:Optional
  val implicit: Boolean? = null,
  @property:SerialName("text")
  @param:Optional
  val text: String? = null,
  @property:SerialName("parsedOk")
  @param:Optional
  val parsedOk: Boolean? = null,
  @property:SerialName("disabled")
  @param:Optional
  val disabled: Boolean? = null,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
  @property:SerialName("longhandProperties")
  @param:Optional
  @param:Experimental
  val longhandProperties: List<CSSProperty>? = null,
)
