@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class PartitioningBlobURLIssueDetails(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("partitioningBlobURLInfo")
  val partitioningBlobURLInfo: PartitioningBlobURLInfo,
)
