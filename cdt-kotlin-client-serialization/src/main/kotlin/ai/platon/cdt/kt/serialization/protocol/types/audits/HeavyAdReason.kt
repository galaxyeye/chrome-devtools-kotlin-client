@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class HeavyAdReason {
  @SerialName("NetworkTotalLimit")
  NETWORK_TOTAL_LIMIT,
  @SerialName("CpuTotalLimit")
  CPU_TOTAL_LIMIT,
  @SerialName("CpuPeakLimit")
  CPU_PEAK_LIMIT,
}
