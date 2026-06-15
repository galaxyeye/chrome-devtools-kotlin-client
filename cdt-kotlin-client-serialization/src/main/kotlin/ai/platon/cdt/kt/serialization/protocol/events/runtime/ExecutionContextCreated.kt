@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExecutionContextDescription

/**
 * Issued when new execution context is created.
 */
@Serializable
data class ExecutionContextCreated(
  @SerialName("context")
  val context: ExecutionContextDescription,
)
