package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Describes a supported image decoding profile with its associated minimum and
 * maximum resolutions and subsampling.
 */
data class ImageDecodeAcceleratorCapability(
  @field:JsonProperty("imageType")
  val imageType: ImageType,
  @field:JsonProperty("maxDimensions")
  val maxDimensions: Size,
  @field:JsonProperty("minDimensions")
  val minDimensions: Size,
  @field:JsonProperty("subsamplings")
  val subsamplings: List<SubsamplingFormat>,
)
