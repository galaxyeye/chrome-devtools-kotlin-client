package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Executable module information
 */
public data class Module(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("uuid")
  public val uuid: String,
  @field:JsonProperty("baseAddress")
  public val baseAddress: String,
  @field:JsonProperty("size")
  public val size: Double,
)
