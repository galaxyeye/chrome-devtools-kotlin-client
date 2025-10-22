package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class BreakLocation(
  @field:JsonProperty("scriptId")
  public val scriptId: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  @param:Optional
  public val columnNumber: Int? = null,
  @field:JsonProperty("type")
  @param:Optional
  public val type: BreakLocationType? = null,
)
