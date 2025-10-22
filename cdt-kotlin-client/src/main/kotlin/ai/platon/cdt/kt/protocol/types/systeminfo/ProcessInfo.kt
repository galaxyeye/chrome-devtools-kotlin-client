package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Represents process info.
 */
data class ProcessInfo(
  @field:JsonProperty("type")
  val type: String,
  @field:JsonProperty("id")
  val id: Int,
  @field:JsonProperty("cpuTime")
  val cpuTime: Double,
)
