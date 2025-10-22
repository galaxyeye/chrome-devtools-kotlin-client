package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class Header(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
)
