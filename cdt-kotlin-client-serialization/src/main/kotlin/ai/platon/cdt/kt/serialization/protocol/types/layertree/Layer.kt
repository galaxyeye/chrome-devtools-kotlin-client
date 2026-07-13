@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a compositing layer.
 */
@Serializable
data class Layer(
  @property:SerialName("layerId")
  val layerId: String,
  @property:SerialName("parentLayerId")
  @param:Optional
  val parentLayerId: String? = null,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @property:SerialName("offsetX")
  val offsetX: Double,
  @property:SerialName("offsetY")
  val offsetY: Double,
  @property:SerialName("width")
  val width: Double,
  @property:SerialName("height")
  val height: Double,
  @property:SerialName("transform")
  @param:Optional
  val transform: List<Double>? = null,
  @property:SerialName("anchorX")
  @param:Optional
  val anchorX: Double? = null,
  @property:SerialName("anchorY")
  @param:Optional
  val anchorY: Double? = null,
  @property:SerialName("anchorZ")
  @param:Optional
  val anchorZ: Double? = null,
  @property:SerialName("paintCount")
  val paintCount: Int,
  @property:SerialName("drawsContent")
  val drawsContent: Boolean,
  @property:SerialName("invisible")
  @param:Optional
  val invisible: Boolean? = null,
  @property:SerialName("scrollRects")
  @param:Optional
  val scrollRects: List<ScrollRect>? = null,
  @property:SerialName("stickyPositionConstraint")
  @param:Optional
  val stickyPositionConstraint: StickyPositionConstraint? = null,
)
