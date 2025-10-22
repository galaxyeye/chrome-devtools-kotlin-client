package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Screen orientation.
 */
data class ScreenOrientation(
  @field:JsonProperty("type")
  val type: ScreenOrientationType,
  @field:JsonProperty("angle")
  val angle: Int,
)
