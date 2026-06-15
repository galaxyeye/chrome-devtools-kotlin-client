@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class SetBreakpoint(
  @SerialName("breakpointId")
  val breakpointId: String,
  @SerialName("actualLocation")
  val actualLocation: Location,
)
