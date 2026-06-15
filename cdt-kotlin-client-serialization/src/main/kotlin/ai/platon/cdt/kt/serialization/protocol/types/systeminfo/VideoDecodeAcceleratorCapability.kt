@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Describes a supported video decoding profile with its associated minimum and
 * maximum resolutions.
 */
@Serializable
data class VideoDecodeAcceleratorCapability(
  @SerialName("profile")
  val profile: String,
  @SerialName("maxResolution")
  val maxResolution: Size,
  @SerialName("minResolution")
  val minResolution: Size,
)
