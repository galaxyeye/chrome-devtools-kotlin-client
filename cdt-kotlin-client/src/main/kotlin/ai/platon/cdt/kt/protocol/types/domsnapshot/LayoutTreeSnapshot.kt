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
public data class LayoutTreeSnapshot(
  @field:JsonProperty("nodeIndex")
  public val nodeIndex: List<Int>,
  @field:JsonProperty("styles")
  public val styles: List<List<Int>>,
  @field:JsonProperty("bounds")
  public val bounds: List<List<Double>>,
  @field:JsonProperty("text")
  public val text: List<Int>,
  @field:JsonProperty("stackingContexts")
  public val stackingContexts: RareBooleanData,
  @field:JsonProperty("paintOrders")
  @param:Optional
  public val paintOrders: List<Int>? = null,
  @field:JsonProperty("offsetRects")
  @param:Optional
  public val offsetRects: List<List<Double>>? = null,
  @field:JsonProperty("scrollRects")
  @param:Optional
  public val scrollRects: List<List<Double>>? = null,
  @field:JsonProperty("clientRects")
  @param:Optional
  public val clientRects: List<List<Double>>? = null,
  @field:JsonProperty("blendedBackgroundColors")
  @param:Optional
  @param:Experimental
  public val blendedBackgroundColors: List<Int>? = null,
  @field:JsonProperty("textColorOpacities")
  @param:Optional
  @param:Experimental
  public val textColorOpacities: List<Double>? = null,
)
