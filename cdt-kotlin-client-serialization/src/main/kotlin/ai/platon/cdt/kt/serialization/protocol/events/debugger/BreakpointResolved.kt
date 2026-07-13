@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.debugger

import ai.platon.cdt.kt.serialization.protocol.types.debugger.Location
import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when breakpoint is resolved to an actual script and location.
 * Deprecated in favor of `resolvedBreakpoints` in the `scriptParsed` event.
 */
@Serializable
@Deprecated("Deprecated")
data class BreakpointResolved(
  @property:SerialName("breakpointId")
  val breakpointId: String,
  @property:SerialName("location")
  val location: Location,
)
