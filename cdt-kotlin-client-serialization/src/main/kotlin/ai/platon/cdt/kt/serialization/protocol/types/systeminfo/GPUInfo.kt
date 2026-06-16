@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Provides information about the GPU(s) on the system.
 */
@Serializable
data class GPUInfo(
  @property:SerialName("devices")
  val devices: List<GPUDevice>,
  @property:SerialName("auxAttributes")
  @param:Optional
  val auxAttributes: JsonObject? = null,
  @property:SerialName("featureStatus")
  @param:Optional
  val featureStatus: JsonObject? = null,
  @property:SerialName("driverBugWorkarounds")
  val driverBugWorkarounds: List<String>,
  @property:SerialName("videoDecoding")
  val videoDecoding: List<VideoDecodeAcceleratorCapability>,
  @property:SerialName("videoEncoding")
  val videoEncoding: List<VideoEncodeAcceleratorCapability>,
  @property:SerialName("imageDecoding")
  val imageDecoding: List<ImageDecodeAcceleratorCapability>,
)
