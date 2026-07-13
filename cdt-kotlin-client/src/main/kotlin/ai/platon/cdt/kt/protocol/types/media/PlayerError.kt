@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.media

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Corresponds to kMediaError
 */
data class PlayerError(
  @param:JsonProperty("errorType")
  val errorType: String,
  @param:JsonProperty("code")
  val code: Int,
  @param:JsonProperty("stack")
  val stack: List<PlayerErrorSourceLocation>,
  @param:JsonProperty("cause")
  val cause: List<PlayerError>,
  @param:JsonProperty("data")
  val `data`: Map<String, Any?>,
)
