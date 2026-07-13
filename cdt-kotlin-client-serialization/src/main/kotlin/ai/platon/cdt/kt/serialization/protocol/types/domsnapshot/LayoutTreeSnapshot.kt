@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Table of details of an element in the DOM tree with a LayoutObject.
 */
@Serializable
data class LayoutTreeSnapshot(
  @property:SerialName("nodeIndex")
  val nodeIndex: List<Int>,
  @property:SerialName("styles")
  val styles: List<List<Int>>,
  @property:SerialName("bounds")
  val bounds: List<List<Double>>,
  @property:SerialName("text")
  val text: List<Int>,
  @property:SerialName("stackingContexts")
  val stackingContexts: RareBooleanData,
  @property:SerialName("paintOrders")
  @param:Optional
  val paintOrders: List<Int>? = null,
  @property:SerialName("offsetRects")
  @param:Optional
  val offsetRects: List<List<Double>>? = null,
  @property:SerialName("scrollRects")
  @param:Optional
  val scrollRects: List<List<Double>>? = null,
  @property:SerialName("clientRects")
  @param:Optional
  val clientRects: List<List<Double>>? = null,
  @property:SerialName("blendedBackgroundColors")
  @param:Optional
  @param:Experimental
  val blendedBackgroundColors: List<Int>? = null,
  @property:SerialName("textColorOpacities")
  @param:Optional
  @param:Experimental
  val textColorOpacities: List<Double>? = null,
)
