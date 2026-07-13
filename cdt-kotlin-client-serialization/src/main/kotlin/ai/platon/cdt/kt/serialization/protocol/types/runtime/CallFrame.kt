@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stack entry for runtime errors and assertions.
 */
@Serializable
data class CallFrame(
  @property:SerialName("functionName")
  val functionName: String,
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
)
