@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Details for a performance issue.
 */
data class PerformanceIssueDetails(
  @param:JsonProperty("performanceIssueType")
  val performanceIssueType: PerformanceIssueType,
  @param:JsonProperty("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
)
