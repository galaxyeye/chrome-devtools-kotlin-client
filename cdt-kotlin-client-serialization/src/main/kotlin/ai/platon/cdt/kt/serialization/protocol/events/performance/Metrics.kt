@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.performance

import ai.platon.cdt.kt.serialization.protocol.types.performance.Metric
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Current values of the metrics.
 */
@Serializable
data class Metrics(
  @property:SerialName("metrics")
  val metrics: List<Metric>,
  @property:SerialName("title")
  val title: String,
)
