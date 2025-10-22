package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class SetBreakpoint(
  @field:JsonProperty("breakpointId")
  public val breakpointId: String,
  @field:JsonProperty("actualLocation")
  public val actualLocation: Location,
)
