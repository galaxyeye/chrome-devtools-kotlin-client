@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

data class TraceConfig(
  @param:JsonProperty("recordMode")
  @param:Optional
  @param:Experimental
  val recordMode: TraceConfigRecordMode? = null,
  @param:JsonProperty("traceBufferSizeInKb")
  @param:Optional
  @param:Experimental
  val traceBufferSizeInKb: Double? = null,
  @param:JsonProperty("enableSampling")
  @param:Optional
  @param:Experimental
  val enableSampling: Boolean? = null,
  @param:JsonProperty("enableSystrace")
  @param:Optional
  @param:Experimental
  val enableSystrace: Boolean? = null,
  @param:JsonProperty("enableArgumentFilter")
  @param:Optional
  @param:Experimental
  val enableArgumentFilter: Boolean? = null,
  @param:JsonProperty("includedCategories")
  @param:Optional
  val includedCategories: List<String>? = null,
  @param:JsonProperty("excludedCategories")
  @param:Optional
  val excludedCategories: List<String>? = null,
  @param:JsonProperty("syntheticDelays")
  @param:Optional
  @param:Experimental
  val syntheticDelays: List<String>? = null,
  @param:JsonProperty("memoryDumpConfig")
  @param:Optional
  @param:Experimental
  val memoryDumpConfig: Map<String, Any?>? = null,
)
