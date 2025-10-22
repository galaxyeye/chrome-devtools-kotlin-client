package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Describes a supported video decoding profile with its associated minimum and
 * maximum resolutions.
 */
public data class VideoDecodeAcceleratorCapability(
  @field:JsonProperty("profile")
  public val profile: String,
  @field:JsonProperty("maxResolution")
  public val maxResolution: Size,
  @field:JsonProperty("minResolution")
  public val minResolution: Size,
)
