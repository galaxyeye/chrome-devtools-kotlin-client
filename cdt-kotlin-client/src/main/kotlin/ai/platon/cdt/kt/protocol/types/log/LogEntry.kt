package ai.platon.cdt.kt.protocol.types.log

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Log entry.
 */
data class LogEntry(
  @field:JsonProperty("source")
  val source: LogEntrySource,
  @field:JsonProperty("level")
  val level: LogEntryLevel,
  @field:JsonProperty("text")
  val text: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("lineNumber")
  @param:Optional
  val lineNumber: Int? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @field:JsonProperty("networkRequestId")
  @param:Optional
  val networkRequestId: String? = null,
  @field:JsonProperty("workerId")
  @param:Optional
  val workerId: String? = null,
  @field:JsonProperty("args")
  @param:Optional
  val args: List<RemoteObject>? = null,
)
