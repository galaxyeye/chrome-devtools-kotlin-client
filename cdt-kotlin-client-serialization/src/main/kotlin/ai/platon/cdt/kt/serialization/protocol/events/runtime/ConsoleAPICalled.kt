@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.ConsoleAPICalledType
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when console API was called.
 */
@Serializable
data class ConsoleAPICalled(
  @property:SerialName("type")
  val type: ConsoleAPICalledType,
  @property:SerialName("args")
  val args: List<RemoteObject>,
  @property:SerialName("executionContextId")
  val executionContextId: Int,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("stackTrace")
  @param:Optional
  val stackTrace: StackTrace? = null,
  @property:SerialName("context")
  @param:Optional
  @param:Experimental
  val context: String? = null,
)
