@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.ads

import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Ad metrics for a page.
 */
@Serializable
data class AdMetrics(
  @property:SerialName("viewportAdDensityByArea")
  val viewportAdDensityByArea: Int,
  @property:SerialName("averageViewportAdDensityByArea")
  val averageViewportAdDensityByArea: Double,
  @property:SerialName("viewportAdCount")
  val viewportAdCount: Int,
  @property:SerialName("averageViewportAdCount")
  val averageViewportAdCount: Double,
  @property:SerialName("totalAdCpuTime")
  val totalAdCpuTime: Double,
  @property:SerialName("totalAdNetworkBytes")
  val totalAdNetworkBytes: Double,
)
