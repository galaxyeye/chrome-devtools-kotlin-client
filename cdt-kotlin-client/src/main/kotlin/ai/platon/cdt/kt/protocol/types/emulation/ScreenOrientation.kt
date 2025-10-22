package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Screen orientation.
 */
public data class ScreenOrientation(
  @field:JsonProperty("type")
  public val type: ScreenOrientationType,
  @field:JsonProperty("angle")
  public val angle: Int,
)
