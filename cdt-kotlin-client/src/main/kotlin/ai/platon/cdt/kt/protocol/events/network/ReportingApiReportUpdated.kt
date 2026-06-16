@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.ReportingApiReport
import com.fasterxml.jackson.`annotation`.JsonProperty

@Experimental
data class ReportingApiReportUpdated(
  @param:JsonProperty("report")
  val report: ReportingApiReport,
)
