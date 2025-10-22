package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Location range within one script.
 */
@Experimental
data class LocationRange(
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("start")
  val start: ScriptPosition,
  @field:JsonProperty("end")
  val end: ScriptPosition,
)
