@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LowTextContrastIssueDetails(
  @property:SerialName("violatingNodeId")
  val violatingNodeId: Int,
  @property:SerialName("violatingNodeSelector")
  val violatingNodeSelector: String,
  @property:SerialName("contrastRatio")
  val contrastRatio: Double,
  @property:SerialName("thresholdAA")
  val thresholdAA: Double,
  @property:SerialName("thresholdAAA")
  val thresholdAAA: Double,
  @property:SerialName("fontSize")
  val fontSize: String,
  @property:SerialName("fontWeight")
  val fontWeight: String,
)
