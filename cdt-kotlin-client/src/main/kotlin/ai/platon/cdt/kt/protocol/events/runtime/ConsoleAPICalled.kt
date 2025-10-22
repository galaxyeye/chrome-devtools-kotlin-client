package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.ConsoleAPICalledType
import ai.platon.cdt.kt.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Issued when console API was called.
 */
public data class ConsoleAPICalled(
  @field:JsonProperty("type")
  public val type: ConsoleAPICalledType,
  @field:JsonProperty("args")
  public val args: List<RemoteObject>,
  @field:JsonProperty("executionContextId")
  public val executionContextId: Int,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("stackTrace")
  @param:Optional
  public val stackTrace: StackTrace? = null,
  @field:JsonProperty("context")
  @param:Optional
  @param:Experimental
  public val context: String? = null,
)
