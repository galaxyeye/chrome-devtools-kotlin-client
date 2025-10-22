package ai.platon.cdt.kt.protocol.types.layertree

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Information about a compositing layer.
 */
data class Layer(
  @field:JsonProperty("layerId")
  val layerId: String,
  @field:JsonProperty("parentLayerId")
  @param:Optional
  val parentLayerId: String? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
  @field:JsonProperty("offsetX")
  val offsetX: Double,
  @field:JsonProperty("offsetY")
  val offsetY: Double,
  @field:JsonProperty("width")
  val width: Double,
  @field:JsonProperty("height")
  val height: Double,
  @field:JsonProperty("transform")
  @param:Optional
  val transform: List<Double>? = null,
  @field:JsonProperty("anchorX")
  @param:Optional
  val anchorX: Double? = null,
  @field:JsonProperty("anchorY")
  @param:Optional
  val anchorY: Double? = null,
  @field:JsonProperty("anchorZ")
  @param:Optional
  val anchorZ: Double? = null,
  @field:JsonProperty("paintCount")
  val paintCount: Int,
  @field:JsonProperty("drawsContent")
  val drawsContent: Boolean,
  @field:JsonProperty("invisible")
  @param:Optional
  val invisible: Boolean? = null,
  @field:JsonProperty("scrollRects")
  @param:Optional
  val scrollRects: List<ScrollRect>? = null,
  @field:JsonProperty("stickyPositionConstraint")
  @param:Optional
  val stickyPositionConstraint: StickyPositionConstraint? = null,
)
