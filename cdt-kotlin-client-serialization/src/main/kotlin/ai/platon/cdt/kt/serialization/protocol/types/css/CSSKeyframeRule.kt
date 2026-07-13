@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS keyframe rule representation.
 */
@Serializable
data class CSSKeyframeRule(
  @property:SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @property:SerialName("origin")
  val origin: StyleSheetOrigin,
  @property:SerialName("keyText")
  val keyText: Value,
  @property:SerialName("style")
  val style: CSSStyle,
)
