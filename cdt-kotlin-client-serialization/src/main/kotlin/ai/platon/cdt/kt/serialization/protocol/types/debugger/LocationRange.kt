@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Location range within one script.
 */
@Experimental
@Serializable
data class LocationRange(
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("start")
  val start: ScriptPosition,
  @SerialName("end")
  val end: ScriptPosition,
)
