package ai.platon.cdt.kt.protocol.types.schema

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Description of the protocol domain.
 */
data class Domain(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("version")
  val version: String,
)
