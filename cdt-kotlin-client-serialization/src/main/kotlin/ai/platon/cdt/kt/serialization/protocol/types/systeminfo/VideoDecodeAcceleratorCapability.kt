@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a supported video decoding profile with its associated minimum and
 * maximum resolutions.
 */
@Serializable
data class VideoDecodeAcceleratorCapability(
  @property:SerialName("profile")
  val profile: String,
  @property:SerialName("maxResolution")
  val maxResolution: Size,
  @property:SerialName("minResolution")
  val minResolution: Size,
)
