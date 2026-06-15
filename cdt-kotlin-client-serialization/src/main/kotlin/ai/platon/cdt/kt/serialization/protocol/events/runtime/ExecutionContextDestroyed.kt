@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Issued when execution context is destroyed.
 */
@Serializable
data class ExecutionContextDestroyed(
  @SerialName("executionContextId")
  val executionContextId: Int,
)
