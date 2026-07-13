@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetBreakpointByUrl(
  @property:SerialName("breakpointId")
  val breakpointId: String,
  @property:SerialName("locations")
  val locations: List<Location>,
)
