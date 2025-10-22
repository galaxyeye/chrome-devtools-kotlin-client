package ai.platon.cdt.kt.protocol.types.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

data class TraceConfig(
  @field:JsonProperty("recordMode")
  @param:Optional
  val recordMode: TraceConfigRecordMode? = null,
  @field:JsonProperty("enableSampling")
  @param:Optional
  val enableSampling: Boolean? = null,
  @field:JsonProperty("enableSystrace")
  @param:Optional
  val enableSystrace: Boolean? = null,
  @field:JsonProperty("enableArgumentFilter")
  @param:Optional
  val enableArgumentFilter: Boolean? = null,
  @field:JsonProperty("includedCategories")
  @param:Optional
  val includedCategories: List<String>? = null,
  @field:JsonProperty("excludedCategories")
  @param:Optional
  val excludedCategories: List<String>? = null,
  @field:JsonProperty("syntheticDelays")
  @param:Optional
  val syntheticDelays: List<String>? = null,
  @field:JsonProperty("memoryDumpConfig")
  @param:Optional
  val memoryDumpConfig: Map<String, Any?>? = null,
)
