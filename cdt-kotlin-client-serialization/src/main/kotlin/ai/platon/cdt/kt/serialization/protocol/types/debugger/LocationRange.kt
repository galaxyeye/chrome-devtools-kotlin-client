@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Location range within one script.
 */
@Serializable
@Experimental
data class LocationRange(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("start")
  val start: ScriptPosition,
  @property:SerialName("end")
  val end: ScriptPosition,
)
