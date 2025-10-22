package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class DisplayFeature(
  @field:JsonProperty("orientation")
  val orientation: DisplayFeatureOrientation,
  @field:JsonProperty("offset")
  val offset: Int,
  @field:JsonProperty("maskLength")
  val maskLength: Int,
)
