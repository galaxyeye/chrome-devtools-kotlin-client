@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.memory

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * DOM object counter data.
 */
data class DOMCounter(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("count")
  val count: Int,
)
