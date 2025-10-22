package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
 * execution.
 */
data class ExceptionDetails(
  @field:JsonProperty("exceptionId")
  val exceptionId: Int,
  @field:JsonProperty("text")
  val text: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  val columnNumber: Int,
  @field:JsonProperty("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @field:JsonProperty("exception")
  @param:Optional
  val exception: RemoteObject? = null,
  @field:JsonProperty("executionContextId")
  @param:Optional
  val executionContextId: Int? = null,
)
