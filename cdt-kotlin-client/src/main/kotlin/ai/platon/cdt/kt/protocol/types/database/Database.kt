package ai.platon.cdt.kt.protocol.types.database

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Database object.
 */
data class Database(
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("domain")
  val domain: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("version")
  val version: String,
)
