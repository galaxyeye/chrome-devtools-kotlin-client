package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class MediaFeature(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
)
