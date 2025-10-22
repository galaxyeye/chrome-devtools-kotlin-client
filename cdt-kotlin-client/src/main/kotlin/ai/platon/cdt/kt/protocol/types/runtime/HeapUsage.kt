package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

data class HeapUsage(
  @field:JsonProperty("usedSize")
  val usedSize: Double,
  @field:JsonProperty("totalSize")
  val totalSize: Double,
)
