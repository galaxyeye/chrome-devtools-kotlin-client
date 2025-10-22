package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Represents process info.
 */
public data class ProcessInfo(
  @field:JsonProperty("type")
  public val type: String,
  @field:JsonProperty("id")
  public val id: Int,
  @field:JsonProperty("cpuTime")
  public val cpuTime: Double,
)
