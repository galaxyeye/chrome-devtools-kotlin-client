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
public data class GPUInfo(
  @field:JsonProperty("devices")
  public val devices: List<GPUDevice>,
  @field:JsonProperty("auxAttributes")
  @param:Optional
  public val auxAttributes: Map<String, Any?>? = null,
  @field:JsonProperty("featureStatus")
  @param:Optional
  public val featureStatus: Map<String, Any?>? = null,
  @field:JsonProperty("driverBugWorkarounds")
  public val driverBugWorkarounds: List<String>,
  @field:JsonProperty("videoDecoding")
  public val videoDecoding: List<VideoDecodeAcceleratorCapability>,
  @field:JsonProperty("videoEncoding")
  public val videoEncoding: List<VideoEncodeAcceleratorCapability>,
  @field:JsonProperty("imageDecoding")
  public val imageDecoding: List<ImageDecodeAcceleratorCapability>,
)
