package ai.platon.cdt.kt.protocol.types.systeminfo

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Provides information about the GPU(s) on the system.
 */
data class GPUInfo(
  @field:JsonProperty("devices")
  val devices: List<GPUDevice>,
  @field:JsonProperty("auxAttributes")
  @param:Optional
  val auxAttributes: Map<String, Any?>? = null,
  @field:JsonProperty("featureStatus")
  @param:Optional
  val featureStatus: Map<String, Any?>? = null,
  @field:JsonProperty("driverBugWorkarounds")
  val driverBugWorkarounds: List<String>,
  @field:JsonProperty("videoDecoding")
  val videoDecoding: List<VideoDecodeAcceleratorCapability>,
  @field:JsonProperty("videoEncoding")
  val videoEncoding: List<VideoEncodeAcceleratorCapability>,
  @field:JsonProperty("imageDecoding")
  val imageDecoding: List<ImageDecodeAcceleratorCapability>,
)
