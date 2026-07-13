@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * CSS Layer data.
 */
@Experimental
data class CSSLayerData(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("subLayers")
  @param:Optional
  val subLayers: List<CSSLayerData>? = null,
  @param:JsonProperty("order")
  val order: Double,
)
