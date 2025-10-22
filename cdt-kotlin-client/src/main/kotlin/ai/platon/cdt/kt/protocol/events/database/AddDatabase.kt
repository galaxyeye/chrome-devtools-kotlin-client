package ai.platon.cdt.kt.protocol.events.database

import ai.platon.cdt.kt.protocol.types.database.Database
import com.fasterxml.jackson.`annotation`.JsonProperty

data class AddDatabase(
  @field:JsonProperty("database")
  val database: Database,
)
