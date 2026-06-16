@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class StorageBucketDeleted(
  @param:JsonProperty("bucketId")
  val bucketId: String,
)
