package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when `Element`'s attribute is removed.
 */
data class AttributeRemoved(
  @field:JsonProperty("nodeId")
  val nodeId: Int,
  @field:JsonProperty("name")
  val name: String,
)
