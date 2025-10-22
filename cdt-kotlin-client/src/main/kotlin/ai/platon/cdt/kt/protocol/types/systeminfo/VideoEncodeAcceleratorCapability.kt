package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Describes a supported video encoding profile with its associated maximum
 * resolution and maximum framerate.
 */
public data class VideoEncodeAcceleratorCapability(
  @field:JsonProperty("profile")
  public val profile: String,
  @field:JsonProperty("maxResolution")
  public val maxResolution: Size,
  @field:JsonProperty("maxFramerateNumerator")
  public val maxFramerateNumerator: Int,
  @field:JsonProperty("maxFramerateDenominator")
  public val maxFramerateDenominator: Int,
)
