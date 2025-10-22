package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Usage for a storage type.
 */
data class UsageForType(
  @field:JsonProperty("storageType")
  val storageType: StorageType,
  @field:JsonProperty("usage")
  val usage: Double,
)
