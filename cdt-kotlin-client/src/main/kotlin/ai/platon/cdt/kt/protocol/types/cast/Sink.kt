package ai.platon.cdt.kt.protocol.types.cast

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class Sink(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("id")
  public val id: String,
  @field:JsonProperty("session")
  @param:Optional
  public val session: String? = null,
)
