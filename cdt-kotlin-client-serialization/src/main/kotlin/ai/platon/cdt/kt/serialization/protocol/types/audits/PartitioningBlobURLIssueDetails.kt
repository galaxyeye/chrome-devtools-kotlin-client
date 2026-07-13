@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PartitioningBlobURLIssueDetails(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("partitioningBlobURLInfo")
  val partitioningBlobURLInfo: PartitioningBlobURLInfo,
)
