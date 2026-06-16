@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.ads

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * Ad metrics for a page.
 */
data class AdMetrics(
  @param:JsonProperty("viewportAdDensityByArea")
  val viewportAdDensityByArea: Int,
  @param:JsonProperty("averageViewportAdDensityByArea")
  val averageViewportAdDensityByArea: Double,
  @param:JsonProperty("viewportAdCount")
  val viewportAdCount: Int,
  @param:JsonProperty("averageViewportAdCount")
  val averageViewportAdCount: Double,
  @param:JsonProperty("totalAdCpuTime")
  val totalAdCpuTime: Double,
  @param:JsonProperty("totalAdNetworkBytes")
  val totalAdNetworkBytes: Double,
)
