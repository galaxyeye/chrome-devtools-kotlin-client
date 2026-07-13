@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeavyAdIssueDetails(
  @property:SerialName("resolution")
  val resolution: HeavyAdResolutionStatus,
  @property:SerialName("reason")
  val reason: HeavyAdReason,
  @property:SerialName("frame")
  val frame: AffectedFrame,
)
