package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class ShorthandEntry(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
  @field:JsonProperty("important")
  @param:Optional
  val important: Boolean? = null,
)
