@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS @position-try rule representation.
 */
@Serializable
data class CSSPositionTryRule(
  @property:SerialName("name")
  val name: Value,
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("style")
  val style: CSSStyle,
  @property:SerialName("active")
  val active: Boolean,
)
