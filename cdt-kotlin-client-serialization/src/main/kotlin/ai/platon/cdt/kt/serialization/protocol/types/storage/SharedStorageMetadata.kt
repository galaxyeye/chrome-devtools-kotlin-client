@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for an origin's shared storage.
 */
@Serializable
data class SharedStorageMetadata(
  @property:SerialName("creationTime")
  val creationTime: Double,
  @property:SerialName("length")
  val length: Int,
  @property:SerialName("remainingBudget")
  val remainingBudget: Double,
  @property:SerialName("bytesUsed")
  val bytesUsed: Int,
)
