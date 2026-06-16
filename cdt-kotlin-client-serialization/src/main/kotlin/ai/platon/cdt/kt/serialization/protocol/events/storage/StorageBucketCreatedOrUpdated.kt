@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.types.storage.StorageBucketInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorageBucketCreatedOrUpdated(
  @property:SerialName("bucketInfo")
  val bucketInfo: StorageBucketInfo,
)
