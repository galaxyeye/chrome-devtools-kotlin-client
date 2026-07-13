@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.ReportingApiReport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Is sent whenever a new report is added.
 * And after 'enableReportingApi' for all existing reports.
 */
@Serializable
@Experimental
data class ReportingApiReportAdded(
  @property:SerialName("report")
  val report: ReportingApiReport,
)
