@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Stack entry for runtime errors and assertions.
 */
@Serializable
data class CallFrame(
  @SerialName("functionName")
  val functionName: String,
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("url")
  val url: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  val columnNumber: Int,
)
