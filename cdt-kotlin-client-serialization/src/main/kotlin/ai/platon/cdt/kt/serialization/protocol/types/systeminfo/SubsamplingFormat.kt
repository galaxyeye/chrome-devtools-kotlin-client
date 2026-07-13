@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * YUV subsampling type of the pixels of a given image.
 */
@Serializable
public enum class SubsamplingFormat {
  @SerialName("yuv420")
  YUV_420,
  @SerialName("yuv422")
  YUV_422,
  @SerialName("yuv444")
  YUV_444,
  UNKNOWN,
}
