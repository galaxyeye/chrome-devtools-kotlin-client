@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Image format of a given image.
 */
@Serializable
public enum class ImageType {
  @SerialName("jpeg")
  JPEG,
  @SerialName("webp")
  WEBP,
  @SerialName("unknown")
  UNKNOWN,
}
