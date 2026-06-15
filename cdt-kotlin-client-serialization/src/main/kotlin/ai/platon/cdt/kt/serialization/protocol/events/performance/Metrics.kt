@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.performance
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.performance.Metric
import kotlin.String
import kotlin.collections.List

/**
 * Current values of the metrics.
 */
@Serializable
data class Metrics(
  @SerialName("metrics")
  val metrics: List<Metric>,
  @SerialName("title")
  val title: String,
)
