package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class Header(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
)
