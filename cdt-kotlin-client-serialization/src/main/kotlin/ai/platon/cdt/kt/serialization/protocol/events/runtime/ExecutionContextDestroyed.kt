@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when execution context is destroyed.
 */
@Serializable
data class ExecutionContextDestroyed(
  @property:SerialName("executionContextId")
  @Deprecated("Deprecated by protocol")
  val executionContextId: Int,
  @property:SerialName("executionContextUniqueId")
  @param:Experimental
  val executionContextUniqueId: String,
)
