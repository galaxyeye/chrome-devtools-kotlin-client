@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Describes a supported video encoding profile with its associated maximum
 * resolution and maximum framerate.
 */
@Serializable
data class VideoEncodeAcceleratorCapability(
  @SerialName("profile")
  val profile: String,
  @SerialName("maxResolution")
  val maxResolution: Size,
  @SerialName("maxFramerateNumerator")
  val maxFramerateNumerator: Int,
  @SerialName("maxFramerateDenominator")
  val maxFramerateDenominator: Int,
)
