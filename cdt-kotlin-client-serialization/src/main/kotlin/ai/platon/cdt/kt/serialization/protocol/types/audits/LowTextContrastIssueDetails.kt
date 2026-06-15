@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int
import kotlin.String

@Serializable
data class LowTextContrastIssueDetails(
  @SerialName("violatingNodeId")
  val violatingNodeId: Int,
  @SerialName("violatingNodeSelector")
  val violatingNodeSelector: String,
  @SerialName("contrastRatio")
  val contrastRatio: Double,
  @SerialName("thresholdAA")
  val thresholdAA: Double,
  @SerialName("thresholdAAA")
  val thresholdAAA: Double,
  @SerialName("fontSize")
  val fontSize: String,
  @SerialName("fontWeight")
  val fontWeight: String,
)
