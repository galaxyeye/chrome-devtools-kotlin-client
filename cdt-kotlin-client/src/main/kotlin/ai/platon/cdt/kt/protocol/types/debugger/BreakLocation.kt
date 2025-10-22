package ai.platon.cdt.kt.protocol.types.debugger

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class BreakLocation(
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  @param:Optional
  val columnNumber: Int? = null,
  @field:JsonProperty("type")
  @param:Optional
  val type: BreakLocationType? = null,
)
