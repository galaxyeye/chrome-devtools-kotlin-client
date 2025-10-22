package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Location range within one script.
 */
@Experimental
public data class LocationRange(
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("start")
  public val start: ScriptPosition,
  @field:JsonProperty("end")
  public val end: ScriptPosition,
)
