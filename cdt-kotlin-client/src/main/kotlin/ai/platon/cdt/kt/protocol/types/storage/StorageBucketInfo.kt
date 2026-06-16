@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

data class StorageBucketInfo(
  @param:JsonProperty("bucket")
  val bucket: StorageBucket,
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("expiration")
  val expiration: Double,
  @param:JsonProperty("quota")
  val quota: Double,
  @param:JsonProperty("persistent")
  val persistent: Boolean,
  @param:JsonProperty("durability")
  val durability: StorageBucketsDurability,
)
