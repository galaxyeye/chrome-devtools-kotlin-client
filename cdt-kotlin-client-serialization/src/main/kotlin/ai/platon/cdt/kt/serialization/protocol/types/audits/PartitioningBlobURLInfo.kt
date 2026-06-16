@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PartitioningBlobURLInfo {
  @SerialName("BlockedCrossPartitionFetching")
  BLOCKED_CROSS_PARTITION_FETCHING,
  @SerialName("EnforceNoopenerForNavigation")
  ENFORCE_NOOPENER_FOR_NAVIGATION,
  UNKNOWN,
}
