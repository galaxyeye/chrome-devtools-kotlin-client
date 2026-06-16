@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InlineStylesForNode(
  @property:SerialName("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @property:SerialName("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
)
