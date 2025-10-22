package ai.platon.cdt.kt.protocol.types.cast

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class Sink(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("session")
  @param:Optional
  val session: String? = null,
)
