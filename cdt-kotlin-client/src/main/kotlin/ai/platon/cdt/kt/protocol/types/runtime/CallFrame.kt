package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Stack entry for runtime errors and assertions.
 */
public data class CallFrame(
  @field:JsonProperty("functionName")
  public val functionName: String,
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
)
