@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.log

import ai.platon.cdt.kt.serialization.protocol.types.log.LogEntry
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when new message was logged.
 */
@Serializable
data class EntryAdded(
  @property:SerialName("entry")
  val entry: LogEntry,
)
