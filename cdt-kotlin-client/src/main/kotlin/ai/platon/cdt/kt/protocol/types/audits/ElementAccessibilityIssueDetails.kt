@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int

/**
 * This issue warns about errors in the select or summary element content model.
 */
data class ElementAccessibilityIssueDetails(
  @param:JsonProperty("nodeId")
  val nodeId: Int,
  @param:JsonProperty("elementAccessibilityIssueReason")
  val elementAccessibilityIssueReason: ElementAccessibilityIssueReason,
  @param:JsonProperty("hasDisallowedAttributes")
  val hasDisallowedAttributes: Boolean,
)
