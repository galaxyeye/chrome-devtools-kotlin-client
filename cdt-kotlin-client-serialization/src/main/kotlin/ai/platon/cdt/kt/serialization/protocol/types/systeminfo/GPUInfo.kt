@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Provides information about the GPU(s) on the system.
 */
@Serializable
data class GPUInfo(
  @SerialName("devices")
  val devices: List<GPUDevice>,
  @SerialName("auxAttributes")
  @param:Optional
  val auxAttributes: Map<String, Any?>? = null,
  @SerialName("featureStatus")
  @param:Optional
  val featureStatus: Map<String, Any?>? = null,
  @SerialName("driverBugWorkarounds")
  val driverBugWorkarounds: List<String>,
  @SerialName("videoDecoding")
  val videoDecoding: List<VideoDecodeAcceleratorCapability>,
  @SerialName("videoEncoding")
  val videoEncoding: List<VideoEncodeAcceleratorCapability>,
  @SerialName("imageDecoding")
  val imageDecoding: List<ImageDecodeAcceleratorCapability>,
)
