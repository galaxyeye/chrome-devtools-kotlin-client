package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired when `Element`'s attribute is modified.
 */
public data class AttributeModified(
  @field:JsonProperty("nodeId")
  public val nodeId: Int,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: String,
)
