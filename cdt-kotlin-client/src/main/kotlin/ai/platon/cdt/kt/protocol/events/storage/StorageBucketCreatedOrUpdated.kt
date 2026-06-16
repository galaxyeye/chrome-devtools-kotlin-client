@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.types.storage.StorageBucketInfo
import com.fasterxml.jackson.`annotation`.JsonProperty

data class StorageBucketCreatedOrUpdated(
  @param:JsonProperty("bucketInfo")
  val bucketInfo: StorageBucketInfo,
)
