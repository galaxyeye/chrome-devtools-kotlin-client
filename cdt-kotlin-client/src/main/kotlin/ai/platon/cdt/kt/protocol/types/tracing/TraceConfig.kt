package ai.platon.cdt.kt.protocol.types.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

public data class TraceConfig(
  @field:JsonProperty("recordMode")
  @param:Optional
  public val recordMode: TraceConfigRecordMode? = null,
  @field:JsonProperty("enableSampling")
  @param:Optional
  public val enableSampling: Boolean? = null,
  @field:JsonProperty("enableSystrace")
  @param:Optional
  public val enableSystrace: Boolean? = null,
  @field:JsonProperty("enableArgumentFilter")
  @param:Optional
  public val enableArgumentFilter: Boolean? = null,
  @field:JsonProperty("includedCategories")
  @param:Optional
  public val includedCategories: List<String>? = null,
  @field:JsonProperty("excludedCategories")
  @param:Optional
  public val excludedCategories: List<String>? = null,
  @field:JsonProperty("syntheticDelays")
  @param:Optional
  public val syntheticDelays: List<String>? = null,
  @field:JsonProperty("memoryDumpConfig")
  @param:Optional
  public val memoryDumpConfig: Map<String, Any?>? = null,
)
