package ai.platon.cdt.kt.protocol.events.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * The origin's IndexedDB object store has been modified.
 */
data class IndexedDBContentUpdated(
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("databaseName")
  val databaseName: String,
  @field:JsonProperty("objectStoreName")
  val objectStoreName: String,
)
