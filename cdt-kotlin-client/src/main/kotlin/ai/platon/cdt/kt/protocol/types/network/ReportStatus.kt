@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The status of a Reporting API report.
 */
public enum class ReportStatus {
  @JsonProperty("Queued")
  QUEUED,
  @JsonProperty("Pending")
  PENDING,
  @JsonProperty("MarkedForRemoval")
  MARKED_FOR_REMOVAL,
  @JsonProperty("Success")
  SUCCESS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
