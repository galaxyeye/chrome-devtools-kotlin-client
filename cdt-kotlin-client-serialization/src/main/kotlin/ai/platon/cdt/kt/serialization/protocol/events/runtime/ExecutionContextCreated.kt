@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExecutionContextDescription
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when new execution context is created.
 */
@Serializable
data class ExecutionContextCreated(
  @property:SerialName("context")
  val context: ExecutionContextDescription,
)
