package ai.platon.cdt.kt.protocol.events.log

import ai.platon.cdt.kt.protocol.types.log.LogEntry
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Issued when new message was logged.
 */
data class EntryAdded(
  @field:JsonProperty("entry")
  val entry: LogEntry,
)
