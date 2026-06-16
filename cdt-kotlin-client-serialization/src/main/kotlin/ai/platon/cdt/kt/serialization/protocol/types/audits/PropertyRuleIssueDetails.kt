@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about errors in property rules that lead to property
 * registrations being ignored.
 */
@Serializable
data class PropertyRuleIssueDetails(
  @property:SerialName("sourceCodeLocation")
  val sourceCodeLocation: SourceCodeLocation,
  @property:SerialName("propertyRuleIssueReason")
  val propertyRuleIssueReason: PropertyRuleIssueReason,
  @property:SerialName("propertyValue")
  @param:Optional
  val propertyValue: String? = null,
)
