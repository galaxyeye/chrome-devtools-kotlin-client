@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for a performance issue.
 */
@Serializable
data class PerformanceIssueDetails(
  @property:SerialName("performanceIssueType")
  val performanceIssueType: PerformanceIssueType,
  @property:SerialName("sourceCodeLocation")
  @param:Optional
  val sourceCodeLocation: SourceCodeLocation? = null,
)
