@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ConsoleAPICalledType
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Issued when console API was called.
 */
@Serializable
data class ConsoleAPICalled(
  @SerialName("type")
  val type: ConsoleAPICalledType,
  @SerialName("args")
  val args: List<RemoteObject>,
  @SerialName("executionContextId")
  val executionContextId: Int,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @SerialName("context")
  @param:Optional
  @param:Experimental
  val context: String? = null,
)
