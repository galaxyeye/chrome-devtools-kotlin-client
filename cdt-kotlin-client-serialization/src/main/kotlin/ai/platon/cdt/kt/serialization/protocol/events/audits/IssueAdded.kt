@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.audits

import ai.platon.cdt.kt.serialization.protocol.types.audits.InspectorIssue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IssueAdded(
  @property:SerialName("issue")
  val issue: InspectorIssue,
)
