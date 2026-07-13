@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes a supported video encoding profile with its associated maximum
 * resolution and maximum framerate.
 */
@Serializable
data class VideoEncodeAcceleratorCapability(
  @property:SerialName("profile")
  val profile: String,
  @property:SerialName("maxResolution")
  val maxResolution: Size,
  @property:SerialName("maxFramerateNumerator")
  val maxFramerateNumerator: Int,
  @property:SerialName("maxFramerateDenominator")
  val maxFramerateDenominator: Int,
)
