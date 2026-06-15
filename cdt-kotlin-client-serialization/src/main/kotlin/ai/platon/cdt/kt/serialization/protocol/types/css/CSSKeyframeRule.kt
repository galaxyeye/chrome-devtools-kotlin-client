@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * CSS keyframe rule representation.
 */
@Serializable
data class CSSKeyframeRule(
  @SerialName("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @SerialName("origin")
  val origin: StyleSheetOrigin,
  @SerialName("keyText")
  val keyText: Value,
  @SerialName("style")
  val style: CSSStyle,
)
