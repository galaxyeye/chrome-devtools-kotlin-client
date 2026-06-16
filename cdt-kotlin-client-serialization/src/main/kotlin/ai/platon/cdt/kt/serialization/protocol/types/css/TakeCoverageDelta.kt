@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TakeCoverageDelta(
  @property:SerialName("coverage")
  val coverage: List<RuleUsage>,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
