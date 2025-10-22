package ai.platon.cdt.kt.protocol.events.performance

import ai.platon.cdt.kt.protocol.types.performance.Metric
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Current values of the metrics.
 */
data class Metrics(
  @field:JsonProperty("metrics")
  val metrics: List<Metric>,
  @field:JsonProperty("title")
  val title: String,
)
