@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Log entry.
 */
@Serializable
data class LogEntry(
  @SerialName("source")
  val source: LogEntrySource,
  @SerialName("level")
  val level: LogEntryLevel,
  @SerialName("text")
  val text: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("lineNumber")
  @param:Optional
  val lineNumber: Int? = null,
  @SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @SerialName("networkRequestId")
  @param:Optional
  val networkRequestId: String? = null,
  @SerialName("workerId")
  @param:Optional
  val workerId: String? = null,
  @SerialName("args")
  @param:Optional
  val args: List<RemoteObject>? = null,
)
