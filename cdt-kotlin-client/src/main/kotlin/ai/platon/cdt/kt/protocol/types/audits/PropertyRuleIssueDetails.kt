@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * This issue warns about errors in property rules that lead to property
 * registrations being ignored.
 */
data class PropertyRuleIssueDetails(
  @param:JsonProperty("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @param:JsonProperty("propertyRuleIssueReason")
  val propertyRuleIssueReason: PropertyRuleIssueReason,
  @param:JsonProperty("propertyValue")
  @param:Optional
  val propertyValue: String? = null,
)
