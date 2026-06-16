@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class TraceConfig(
  @property:SerialName("recordMode")
  @param:Optional
  val recordMode: TraceConfigRecordMode? = null,
  @property:SerialName("enableSampling")
  @param:Optional
  val enableSampling: Boolean? = null,
  @property:SerialName("enableSystrace")
  @param:Optional
  val enableSystrace: Boolean? = null,
  @property:SerialName("enableArgumentFilter")
  @param:Optional
  val enableArgumentFilter: Boolean? = null,
  @property:SerialName("includedCategories")
  @param:Optional
  val includedCategories: List<String>? = null,
  @property:SerialName("excludedCategories")
  @param:Optional
  val excludedCategories: List<String>? = null,
  @property:SerialName("syntheticDelays")
  @param:Optional
  val syntheticDelays: List<String>? = null,
  @property:SerialName("memoryDumpConfig")
  @param:Optional
  val memoryDumpConfig: JsonObject? = null,
)
