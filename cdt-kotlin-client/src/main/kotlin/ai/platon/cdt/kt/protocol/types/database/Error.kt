package ai.platon.cdt.kt.protocol.types.database

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Database error.
 */
data class Error(
  @field:JsonProperty("message")
  val message: String,
  @field:JsonProperty("code")
  val code: Int,
)
