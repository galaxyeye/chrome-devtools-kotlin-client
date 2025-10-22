package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class MediaFeature(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
)
