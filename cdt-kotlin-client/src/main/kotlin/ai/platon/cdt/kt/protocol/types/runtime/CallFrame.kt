package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Stack entry for runtime errors and assertions.
 */
data class CallFrame(
  @field:JsonProperty("functionName")
  val functionName: String,
  @field:JsonProperty("scriptId")
  val scriptId: String,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  val columnNumber: Int,
)
