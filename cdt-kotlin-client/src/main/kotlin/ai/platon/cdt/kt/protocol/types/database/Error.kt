package ai.platon.cdt.kt.protocol.types.database

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Database error.
 */
public data class Error(
  @field:JsonProperty("message")
  public val message: String,
  @field:JsonProperty("code")
  public val code: Int,
)
