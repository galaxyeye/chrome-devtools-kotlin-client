@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StorageBucketDeleted(
  @property:SerialName("bucketId")
  val bucketId: String,
)
