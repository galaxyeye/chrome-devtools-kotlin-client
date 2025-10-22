package ai.platon.cdt.kt.protocol.types.browser

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class WindowForTarget(
  @field:JsonProperty("windowId")
  val windowId: Int,
  @field:JsonProperty("bounds")
  val bounds: Bounds,
)
