@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The status of a Reporting API report.
 */
@Serializable
public enum class ReportStatus {
  @SerialName("Queued")
  QUEUED,
  @SerialName("Pending")
  PENDING,
  @SerialName("MarkedForRemoval")
  MARKED_FOR_REMOVAL,
  @SerialName("Success")
  SUCCESS,
  UNKNOWN,
}
