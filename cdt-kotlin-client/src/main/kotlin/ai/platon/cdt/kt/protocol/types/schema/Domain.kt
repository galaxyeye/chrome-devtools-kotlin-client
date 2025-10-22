package ai.platon.cdt.kt.protocol.types.schema

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Description of the protocol domain.
 */
public data class Domain(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("version")
  public val version: String,
)
