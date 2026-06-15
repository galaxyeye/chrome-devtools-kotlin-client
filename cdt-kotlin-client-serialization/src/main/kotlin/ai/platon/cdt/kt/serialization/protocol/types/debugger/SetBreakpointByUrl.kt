@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String
import kotlin.collections.List

@Serializable
data class SetBreakpointByUrl(
  @SerialName("breakpointId")
  val breakpointId: String,
  @SerialName("locations")
  val locations: List<Location>,
)
