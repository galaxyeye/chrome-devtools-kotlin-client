package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

public data class DisplayFeature(
  @field:JsonProperty("orientation")
  public val orientation: DisplayFeatureOrientation,
  @field:JsonProperty("offset")
  public val offset: Int,
  @field:JsonProperty("maskLength")
  public val maskLength: Int,
)
