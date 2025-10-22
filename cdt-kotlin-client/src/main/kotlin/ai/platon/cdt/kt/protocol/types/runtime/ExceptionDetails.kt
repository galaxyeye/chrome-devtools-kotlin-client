package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
 * execution.
 */
public data class ExceptionDetails(
  @field:JsonProperty("exceptionId")
  public val exceptionId: Int,
  @field:JsonProperty("text")
  public val text: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
  @field:JsonProperty("scriptId")
  @param:Optional
  public val scriptId: String? = null,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  public val stackTrace: StackTrace? = null,
  @field:JsonProperty("exception")
  @param:Optional
  public val exception: RemoteObject? = null,
  @field:JsonProperty("executionContextId")
  @param:Optional
  public val executionContextId: Int? = null,
)
