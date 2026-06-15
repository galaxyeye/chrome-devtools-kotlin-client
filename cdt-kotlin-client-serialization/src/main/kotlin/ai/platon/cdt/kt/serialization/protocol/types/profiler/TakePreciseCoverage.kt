@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.collections.List

@Serializable
data class TakePreciseCoverage(
  @SerialName("result")
  val result: List<ScriptCoverage>,
  @SerialName("timestamp")
  val timestamp: Double,
)
