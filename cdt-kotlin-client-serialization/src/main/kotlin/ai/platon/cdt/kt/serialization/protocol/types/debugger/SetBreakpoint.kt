@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetBreakpoint(
  @property:SerialName("breakpointId")
  val breakpointId: String,
  @property:SerialName("actualLocation")
  val actualLocation: Location,
)
