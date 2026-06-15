@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import kotlin.String

/**
 * Fired when breakpoint is resolved to an actual script and location.
 */
@Serializable
data class BreakpointResolved(
  @SerialName("breakpointId")
  val breakpointId: String,
  @SerialName("location")
  val location: Location,
)
