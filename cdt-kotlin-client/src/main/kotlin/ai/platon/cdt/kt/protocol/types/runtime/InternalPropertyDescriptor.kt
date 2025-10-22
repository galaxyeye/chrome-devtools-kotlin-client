package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Object internal property descriptor. This property isn't normally visible in JavaScript code.
 */
data class InternalPropertyDescriptor(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: RemoteObject? = null,
)
