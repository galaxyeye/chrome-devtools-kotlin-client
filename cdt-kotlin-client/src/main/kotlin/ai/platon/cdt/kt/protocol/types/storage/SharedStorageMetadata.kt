@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * Details for an origin's shared storage.
 */
data class SharedStorageMetadata(
  @param:JsonProperty("creationTime")
  val creationTime: Double,
  @param:JsonProperty("length")
  val length: Int,
  @param:JsonProperty("remainingBudget")
  val remainingBudget: Double,
  @param:JsonProperty("bytesUsed")
  val bytesUsed: Int,
)
