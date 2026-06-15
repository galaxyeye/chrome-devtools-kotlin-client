@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

@Serializable
data class TraceConfig(
  @SerialName("recordMode")
  @param:Optional
  val recordMode: TraceConfigRecordMode? = null,
  @SerialName("enableSampling")
  @param:Optional
  val enableSampling: Boolean? = null,
  @SerialName("enableSystrace")
  @param:Optional
  val enableSystrace: Boolean? = null,
  @SerialName("enableArgumentFilter")
  @param:Optional
  val enableArgumentFilter: Boolean? = null,
  @SerialName("includedCategories")
  @param:Optional
  val includedCategories: List<String>? = null,
  @SerialName("excludedCategories")
  @param:Optional
  val excludedCategories: List<String>? = null,
  @SerialName("syntheticDelays")
  @param:Optional
  val syntheticDelays: List<String>? = null,
  @SerialName("memoryDumpConfig")
  @param:Optional
  val memoryDumpConfig: Map<String, Any?>? = null,
)
