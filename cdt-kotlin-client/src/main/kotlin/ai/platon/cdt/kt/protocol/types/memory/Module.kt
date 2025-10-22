package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Executable module information
 */
data class Module(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("uuid")
  val uuid: String,
  @field:JsonProperty("baseAddress")
  val baseAddress: String,
  @field:JsonProperty("size")
  val size: Double,
)
