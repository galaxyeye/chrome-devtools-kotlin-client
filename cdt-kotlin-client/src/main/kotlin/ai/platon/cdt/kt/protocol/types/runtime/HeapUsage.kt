package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

public data class HeapUsage(
  @field:JsonProperty("usedSize")
  public val usedSize: Double,
  @field:JsonProperty("totalSize")
  public val totalSize: Double,
)
