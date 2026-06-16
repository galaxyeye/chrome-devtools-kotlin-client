@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class ComputedStyleForNode(
  @param:JsonProperty("computedStyle")
  val computedStyle: List<CSSComputedStyleProperty>,
  @param:JsonProperty("extraFields")
  @param:Experimental
  val extraFields: ComputedStyleExtraFields,
)
