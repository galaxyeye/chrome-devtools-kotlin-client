package ai.platon.cdt.kt.protocol.events.performance

import ai.platon.cdt.kt.protocol.types.performance.Metric
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Current values of the metrics.
 */
public data class Metrics(
  @field:JsonProperty("metrics")
  public val metrics: List<Metric>,
  @field:JsonProperty("title")
  public val title: String,
)
