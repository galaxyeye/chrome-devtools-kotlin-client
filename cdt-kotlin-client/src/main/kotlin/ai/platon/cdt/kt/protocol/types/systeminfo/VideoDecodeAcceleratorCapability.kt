package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Describes a supported video decoding profile with its associated minimum and
 * maximum resolutions.
 */
data class VideoDecodeAcceleratorCapability(
  @field:JsonProperty("profile")
  val profile: String,
  @field:JsonProperty("maxResolution")
  val maxResolution: Size,
  @field:JsonProperty("minResolution")
  val minResolution: Size,
)
