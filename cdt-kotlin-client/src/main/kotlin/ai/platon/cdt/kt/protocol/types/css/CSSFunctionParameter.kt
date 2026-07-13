@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS function argument representation.
 */
data class CSSFunctionParameter(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("type")
  val type: String,
)
