@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorageBucketInfo(
  @property:SerialName("bucket")
  val bucket: StorageBucket,
  @property:SerialName("id")
  val id: String,
  @property:SerialName("expiration")
  val expiration: Double,
  @property:SerialName("quota")
  val quota: Double,
  @property:SerialName("persistent")
  val persistent: Boolean,
  @property:SerialName("durability")
  val durability: StorageBucketsDurability,
)
