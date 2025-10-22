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
public data class LogEntry(
  @field:JsonProperty("source")
  public val source: LogEntrySource,
  @field:JsonProperty("level")
  public val level: LogEntryLevel,
  @field:JsonProperty("text")
  public val text: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("lineNumber")
  @param:Optional
  public val lineNumber: Int? = null,
  @field:JsonProperty("stackTrace")
  @param:Optional
  public val stackTrace: StackTrace? = null,
  @field:JsonProperty("networkRequestId")
  @param:Optional
  public val networkRequestId: String? = null,
  @field:JsonProperty("workerId")
  @param:Optional
  public val workerId: String? = null,
  @field:JsonProperty("args")
  @param:Optional
  public val args: List<RemoteObject>? = null,
)
