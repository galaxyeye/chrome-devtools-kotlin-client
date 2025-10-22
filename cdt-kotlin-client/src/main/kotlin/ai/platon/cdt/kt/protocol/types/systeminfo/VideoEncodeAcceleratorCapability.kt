package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Describes a supported video encoding profile with its associated maximum
 * resolution and maximum framerate.
 */
data class VideoEncodeAcceleratorCapability(
  @field:JsonProperty("profile")
  val profile: String,
  @field:JsonProperty("maxResolution")
  val maxResolution: Size,
  @field:JsonProperty("maxFramerateNumerator")
  val maxFramerateNumerator: Int,
  @field:JsonProperty("maxFramerateDenominator")
  val maxFramerateDenominator: Int,
)
