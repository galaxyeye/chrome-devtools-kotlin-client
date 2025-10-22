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
data class ConsoleAPICalled(
  @field:JsonProperty("type")
  val type: ConsoleAPICalledType,
  @field:JsonProperty("args")
  val args: List<RemoteObject>,
  @field:JsonProperty("executionContextId")
  val executionContextId: Int,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @field:JsonProperty("context")
  @param:Optional
  @param:Experimental
  val context: String? = null,
)
