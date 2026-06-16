@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed information about exception (or error) that was thrown during script compilation or
 * execution.
 */
@Serializable
data class ExceptionDetails(
  @property:SerialName("exceptionId")
  val exceptionId: Int,
  @property:SerialName("text")
  val text: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
  @property:SerialName("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @property:SerialName("exception")
  @param:Optional
  val exception: RemoteObject? = null,
  @property:SerialName("executionContextId")
  @param:Optional
  val executionContextId: Int? = null,
)
