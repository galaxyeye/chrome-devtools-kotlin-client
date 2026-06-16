@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS property at-rule representation.
 */
@Serializable
data class CSSPropertyRule(
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("propertyName")
  val propertyName: Value,
  @property:SerialName("style")
  val style: CSSStyle,
)
