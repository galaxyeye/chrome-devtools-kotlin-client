@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Usage for a storage type.
 */
@Serializable
data class UsageForType(
  @property:SerialName("storageType")
  val storageType: StorageType,
  @property:SerialName("usage")
  val usage: Double,
)
