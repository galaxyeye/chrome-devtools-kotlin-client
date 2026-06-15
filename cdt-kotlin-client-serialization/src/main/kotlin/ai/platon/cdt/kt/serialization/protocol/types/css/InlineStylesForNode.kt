@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional

@Serializable
data class InlineStylesForNode(
  @SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @SerialName("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
)
