@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class StorageBucketsDurability {
  @SerialName("relaxed")
  RELAXED,
  @SerialName("strict")
  STRICT,
  UNKNOWN,
}
