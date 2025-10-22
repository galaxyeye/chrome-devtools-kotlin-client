package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class SetBreakpoint(
  @field:JsonProperty("breakpointId")
  val breakpointId: String,
  @field:JsonProperty("actualLocation")
  val actualLocation: Location,
)
