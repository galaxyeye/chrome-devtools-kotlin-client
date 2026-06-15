@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Table of details of an element in the DOM tree with a LayoutObject.
 */
@Serializable
data class LayoutTreeSnapshot(
  @SerialName("nodeIndex")
  val nodeIndex: List<Int>,
  @SerialName("styles")
  val styles: List<List<Int>>,
  @SerialName("bounds")
  val bounds: List<List<Double>>,
  @SerialName("text")
  val text: List<Int>,
  @SerialName("stackingContexts")
  val stackingContexts: RareBooleanData,
  @SerialName("paintOrders")
  @param:Optional
  val paintOrders: List<Int>? = null,
  @SerialName("offsetRects")
  @param:Optional
  val offsetRects: List<List<Double>>? = null,
  @SerialName("scrollRects")
  @param:Optional
  val scrollRects: List<List<Double>>? = null,
  @SerialName("clientRects")
  @param:Optional
  val clientRects: List<List<Double>>? = null,
  @SerialName("blendedBackgroundColors")
  @param:Optional
  @param:Experimental
  val blendedBackgroundColors: List<Int>? = null,
  @SerialName("textColorOpacities")
  @param:Optional
  @param:Experimental
  val textColorOpacities: List<Double>? = null,
)
