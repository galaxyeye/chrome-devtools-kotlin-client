@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.ReportingApiReport
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Is sent whenever a new report is added.
 * And after 'enableReportingApi' for all existing reports.
 */
@Experimental
data class ReportingApiReportAdded(
  @param:JsonProperty("report")
  val report: ReportingApiReport,
)
