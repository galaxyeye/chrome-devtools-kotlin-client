@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.audits.InspectorIssue

@Serializable
data class IssueAdded(
  @SerialName("issue")
  val issue: InspectorIssue,
)
