@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

/**
 * Usage for a storage type.
 */
@Serializable
data class UsageForType(
  @SerialName("storageType")
  val storageType: StorageType,
  @SerialName("usage")
  val usage: Double,
)
