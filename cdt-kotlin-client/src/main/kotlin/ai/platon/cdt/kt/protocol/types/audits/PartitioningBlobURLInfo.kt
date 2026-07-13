@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PartitioningBlobURLInfo {
  @JsonProperty("BlockedCrossPartitionFetching")
  BLOCKED_CROSS_PARTITION_FETCHING,
  @JsonProperty("EnforceNoopenerForNavigation")
  ENFORCE_NOOPENER_FOR_NAVIGATION,
  @JsonEnumDefaultValue
  UNKNOWN,
}
