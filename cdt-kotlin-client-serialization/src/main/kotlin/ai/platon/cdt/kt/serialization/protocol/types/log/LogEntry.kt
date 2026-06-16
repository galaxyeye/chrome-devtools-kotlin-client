@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Log entry.
 */
@Serializable
data class LogEntry(
  @property:SerialName("source")
  val source: LogEntrySource,
  @property:SerialName("level")
  val level: LogEntryLevel,
  @property:SerialName("text")
  val text: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("lineNumber")
  @param:Optional
  val lineNumber: Int? = null,
  @property:SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @property:SerialName("networkRequestId")
  @param:Optional
  val networkRequestId: String? = null,
  @property:SerialName("workerId")
  @param:Optional
  val workerId: String? = null,
  @property:SerialName("args")
  @param:Optional
  val args: List<RemoteObject>? = null,
)
