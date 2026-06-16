@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TraceConfig(
  @property:SerialName("recordMode")
  @param:Optional
  @param:Experimental
  val recordMode: TraceConfigRecordMode? = null,
  @property:SerialName("traceBufferSizeInKb")
  @param:Optional
  @param:Experimental
  val traceBufferSizeInKb: Double? = null,
  @property:SerialName("enableSampling")
  @param:Optional
  @param:Experimental
  val enableSampling: Boolean? = null,
  @property:SerialName("enableSystrace")
  @param:Optional
  @param:Experimental
  val enableSystrace: Boolean? = null,
  @property:SerialName("enableArgumentFilter")
  @param:Optional
  @param:Experimental
  val enableArgumentFilter: Boolean? = null,
  @property:SerialName("includedCategories")
  @param:Optional
  val includedCategories: List<String>? = null,
  @property:SerialName("excludedCategories")
  @param:Optional
  val excludedCategories: List<String>? = null,
  @property:SerialName("syntheticDelays")
  @param:Optional
  @param:Experimental
  val syntheticDelays: List<String>? = null,
  @property:SerialName("memoryDumpConfig")
  @param:Optional
  @param:Experimental
  val memoryDumpConfig: JsonObject? = null,
)
