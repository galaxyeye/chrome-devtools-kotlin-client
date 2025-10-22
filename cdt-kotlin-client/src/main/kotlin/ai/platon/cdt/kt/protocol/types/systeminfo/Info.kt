package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class Info(
  @field:JsonProperty("gpu")
  public val gpu: GPUInfo,
  @field:JsonProperty("modelName")
  public val modelName: String,
  @field:JsonProperty("modelVersion")
  public val modelVersion: String,
  @field:JsonProperty("commandLine")
  public val commandLine: String,
)
