package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Location in the source code.
 */
@Experimental
public data class ScriptPosition(
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
)
