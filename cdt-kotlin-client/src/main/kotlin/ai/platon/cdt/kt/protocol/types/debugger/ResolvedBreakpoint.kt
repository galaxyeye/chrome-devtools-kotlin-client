@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class ResolvedBreakpoint(
  @param:JsonProperty("breakpointId")
  val breakpointId: String,
  @param:JsonProperty("location")
  val location: Location,
)
