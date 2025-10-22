package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A name/value pair.
 */
data class NameValue(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: String,
)
