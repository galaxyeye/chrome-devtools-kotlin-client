@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.collections.List

/**
 * Describes a supported image decoding profile with its associated minimum and
 * maximum resolutions and subsampling.
 */
@Serializable
data class ImageDecodeAcceleratorCapability(
  @SerialName("imageType")
  val imageType: ImageType,
  @SerialName("maxDimensions")
  val maxDimensions: Size,
  @SerialName("minDimensions")
  val minDimensions: Size,
  @SerialName("subsamplings")
  val subsamplings: List<SubsamplingFormat>,
)
