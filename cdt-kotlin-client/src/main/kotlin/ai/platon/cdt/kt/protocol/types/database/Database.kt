package ai.platon.cdt.kt.protocol.types.database

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Database object.
 */
public data class Database(
  @field:JsonProperty("id")
  public val id: String,
  @field:JsonProperty("domain")
  public val domain: String,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("version")
  public val version: String,
)
