@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of image types that can be disabled.
 */
@Serializable
public enum class DisabledImageType {
  @SerialName("avif")
  AVIF,
  @SerialName("jxl")
  JXL,
  @SerialName("webp")
  WEBP,
  UNKNOWN,
}
