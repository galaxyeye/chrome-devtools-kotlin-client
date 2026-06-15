@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Information about a compositing layer.
 */
@Serializable
data class Layer(
  @SerialName("layerId")
  val layerId: String,
  @SerialName("parentLayerId")
  @param:Optional
  val parentLayerId: String? = null,
  @SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @SerialName("offsetX")
  val offsetX: Double,
  @SerialName("offsetY")
  val offsetY: Double,
  @SerialName("width")
  val width: Double,
  @SerialName("height")
  val height: Double,
  @SerialName("transform")
  @param:Optional
  val transform: List<Double>? = null,
  @SerialName("anchorX")
  @param:Optional
  val anchorX: Double? = null,
  @SerialName("anchorY")
  @param:Optional
  val anchorY: Double? = null,
  @SerialName("anchorZ")
  @param:Optional
  val anchorZ: Double? = null,
  @SerialName("paintCount")
  val paintCount: Int,
  @SerialName("drawsContent")
  val drawsContent: Boolean,
  @SerialName("invisible")
  @param:Optional
  val invisible: Boolean? = null,
  @SerialName("scrollRects")
  @param:Optional
  val scrollRects: List<ScrollRect>? = null,
  @SerialName("stickyPositionConstraint")
  @param:Optional
  val stickyPositionConstraint: StickyPositionConstraint? = null,
)
