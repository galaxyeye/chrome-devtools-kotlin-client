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
public data class Layer(
  @field:JsonProperty("layerId")
  public val layerId: String,
  @field:JsonProperty("parentLayerId")
  @param:Optional
  public val parentLayerId: String? = null,
  @field:JsonProperty("backendNodeId")
  @param:Optional
  public val backendNodeId: Int? = null,
  @field:JsonProperty("offsetX")
  public val offsetX: Double,
  @field:JsonProperty("offsetY")
  public val offsetY: Double,
  @field:JsonProperty("width")
  public val width: Double,
  @field:JsonProperty("height")
  public val height: Double,
  @field:JsonProperty("transform")
  @param:Optional
  public val transform: List<Double>? = null,
  @field:JsonProperty("anchorX")
  @param:Optional
  public val anchorX: Double? = null,
  @field:JsonProperty("anchorY")
  @param:Optional
  public val anchorY: Double? = null,
  @field:JsonProperty("anchorZ")
  @param:Optional
  public val anchorZ: Double? = null,
  @field:JsonProperty("paintCount")
  public val paintCount: Int,
  @field:JsonProperty("drawsContent")
  public val drawsContent: Boolean,
  @field:JsonProperty("invisible")
  @param:Optional
  public val invisible: Boolean? = null,
  @field:JsonProperty("scrollRects")
  @param:Optional
  public val scrollRects: List<ScrollRect>? = null,
  @field:JsonProperty("stickyPositionConstraint")
  @param:Optional
  public val stickyPositionConstraint: StickyPositionConstraint? = null,
)
