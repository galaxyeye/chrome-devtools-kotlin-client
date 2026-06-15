@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
data class HeavyAdIssueDetails(
  @SerialName("resolution")
  val resolution: HeavyAdResolutionStatus,
  @SerialName("reason")
  val reason: HeavyAdReason,
  @SerialName("frame")
  val frame: AffectedFrame,
)
