@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TakePreciseCoverage(
  @property:SerialName("result")
  val result: List<ScriptCoverage>,
  @property:SerialName("timestamp")
  val timestamp: Double,
)
