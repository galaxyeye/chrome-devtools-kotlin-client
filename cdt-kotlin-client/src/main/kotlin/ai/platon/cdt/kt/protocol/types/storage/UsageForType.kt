package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Usage for a storage type.
 */
public data class UsageForType(
  @field:JsonProperty("storageType")
  public val storageType: StorageType,
  @field:JsonProperty("usage")
  public val usage: Double,
)
