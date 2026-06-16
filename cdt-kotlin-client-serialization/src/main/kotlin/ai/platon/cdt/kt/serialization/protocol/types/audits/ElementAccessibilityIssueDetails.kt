@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.Boolean
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This issue warns about errors in the select or summary element content model.
 */
@Serializable
data class ElementAccessibilityIssueDetails(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("elementAccessibilityIssueReason")
  val elementAccessibilityIssueReason: ElementAccessibilityIssueReason,
  @property:SerialName("hasDisallowedAttributes")
  val hasDisallowedAttributes: Boolean,
)
