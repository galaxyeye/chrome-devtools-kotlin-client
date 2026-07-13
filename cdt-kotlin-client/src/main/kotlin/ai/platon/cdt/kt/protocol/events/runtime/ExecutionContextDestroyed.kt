@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Deprecated
import kotlin.Int
import kotlin.String

/**
 * Issued when execution context is destroyed.
 */
data class ExecutionContextDestroyed(
  @param:JsonProperty("executionContextId")
  @Deprecated("Deprecated by protocol")
  val executionContextId: Int,
  @param:JsonProperty("executionContextUniqueId")
  @param:Experimental
  val executionContextUniqueId: String,
)
