@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class GatedAPIFeatures {
  @SerialName("SharedArrayBuffers")
  SHARED_ARRAY_BUFFERS,
  @SerialName("SharedArrayBuffersTransferAllowed")
  SHARED_ARRAY_BUFFERS_TRANSFER_ALLOWED,
  @SerialName("PerformanceMeasureMemory")
  PERFORMANCE_MEASURE_MEMORY,
  @SerialName("PerformanceProfile")
  PERFORMANCE_PROFILE,
}
