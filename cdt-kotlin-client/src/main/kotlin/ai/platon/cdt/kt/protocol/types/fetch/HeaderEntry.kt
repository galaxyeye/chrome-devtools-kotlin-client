package ai.platon.cdt.kt.protocol.types.fetch

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Response HTTP header entry
 */
data class HeaderEntry(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
)
