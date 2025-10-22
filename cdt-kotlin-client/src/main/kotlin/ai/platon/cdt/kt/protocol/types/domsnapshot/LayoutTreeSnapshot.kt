package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Table of details of an element in the DOM tree with a LayoutObject.
 */
data class LayoutTreeSnapshot(
  @field:JsonProperty("nodeIndex")
  val nodeIndex: List<Int>,
  @field:JsonProperty("styles")
  val styles: List<List<Int>>,
  @field:JsonProperty("bounds")
  val bounds: List<List<Double>>,
  @field:JsonProperty("text")
  val text: List<Int>,
  @field:JsonProperty("stackingContexts")
  val stackingContexts: RareBooleanData,
  @field:JsonProperty("paintOrders")
  @param:Optional
  val paintOrders: List<Int>? = null,
  @field:JsonProperty("offsetRects")
  @param:Optional
  val offsetRects: List<List<Double>>? = null,
  @field:JsonProperty("scrollRects")
  @param:Optional
  val scrollRects: List<List<Double>>? = null,
  @field:JsonProperty("clientRects")
  @param:Optional
  val clientRects: List<List<Double>>? = null,
  @field:JsonProperty("blendedBackgroundColors")
  @param:Optional
  @param:Experimental
  val blendedBackgroundColors: List<Int>? = null,
  @field:JsonProperty("textColorOpacities")
  @param:Optional
  @param:Experimental
  val textColorOpacities: List<Double>? = null,
)
