@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a supported image decoding profile with its associated minimum and
 * maximum resolutions and subsampling.
 */
@Serializable
data class ImageDecodeAcceleratorCapability(
  @property:SerialName("imageType")
  val imageType: ImageType,
  @property:SerialName("maxDimensions")
  val maxDimensions: Size,
  @property:SerialName("minDimensions")
  val minDimensions: Size,
  @property:SerialName("subsamplings")
  val subsamplings: List<SubsamplingFormat>,
)
