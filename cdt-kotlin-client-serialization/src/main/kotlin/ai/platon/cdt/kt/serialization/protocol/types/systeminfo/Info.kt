@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
  @property:SerialName("gpu")
  val gpu: GPUInfo,
  @property:SerialName("modelName")
  val modelName: String,
  @property:SerialName("modelVersion")
  val modelVersion: String,
  @property:SerialName("commandLine")
  val commandLine: String,
)
