package ai.platon.cdt.kt.protocol.events.database

import ai.platon.cdt.kt.protocol.types.database.Database
import com.fasterxml.jackson.`annotation`.JsonProperty

public data class AddDatabase(
  @field:JsonProperty("database")
  public val database: Database,
)
