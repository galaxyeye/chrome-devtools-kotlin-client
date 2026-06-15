@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
 * execution.
 */
@Serializable
data class ExceptionDetails(
  @SerialName("exceptionId")
  val exceptionId: Int,
  @SerialName("text")
  val text: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  val columnNumber: Int,
  @SerialName("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @SerialName("exception")
  @param:Optional
  val exception: RemoteObject? = null,
  @SerialName("executionContextId")
  @param:Optional
  val executionContextId: Int? = null,
)
