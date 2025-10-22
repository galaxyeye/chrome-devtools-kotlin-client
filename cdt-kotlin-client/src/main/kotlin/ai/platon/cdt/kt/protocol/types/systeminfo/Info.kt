package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class Info(
  @field:JsonProperty("gpu")
  val gpu: GPUInfo,
  @field:JsonProperty("modelName")
  val modelName: String,
  @field:JsonProperty("modelVersion")
  val modelVersion: String,
  @field:JsonProperty("commandLine")
  val commandLine: String,
)
