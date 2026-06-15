@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class Info(
  @SerialName("gpu")
  val gpu: GPUInfo,
  @SerialName("modelName")
  val modelName: String,
  @SerialName("modelVersion")
  val modelVersion: String,
  @SerialName("commandLine")
  val commandLine: String,
)
