package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class SetBreakpointByUrl(
  @field:JsonProperty("breakpointId")
  val breakpointId: String,
  @field:JsonProperty("locations")
  val locations: List<Location>,
)
