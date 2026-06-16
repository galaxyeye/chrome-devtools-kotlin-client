@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when execution context is destroyed.
 */
@Serializable
data class ExecutionContextDestroyed(
  @property:SerialName("executionContextId")
  val executionContextId: Int,
)
