package ai.platon.cdt.kt.protocol.events.storage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * The origin's IndexedDB object store has been modified.
 */
public data class IndexedDBContentUpdated(
  @field:JsonProperty("origin")
  public val origin: String,
  @field:JsonProperty("databaseName")
  public val databaseName: String,
  @field:JsonProperty("objectStoreName")
  public val objectStoreName: String,
)
