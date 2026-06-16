@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ComputedStyleForNode(
  @property:SerialName("computedStyle")
  val computedStyle: List<CSSComputedStyleProperty>,
  @property:SerialName("extraFields")
  @param:Experimental
  val extraFields: ComputedStyleExtraFields,
)
