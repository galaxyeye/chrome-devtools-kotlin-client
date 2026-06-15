@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.collections.List

@Serializable
data class TakeCoverageDelta(
  @SerialName("coverage")
  val coverage: List<RuleUsage>,
  @SerialName("timestamp")
  val timestamp: Double,
)
