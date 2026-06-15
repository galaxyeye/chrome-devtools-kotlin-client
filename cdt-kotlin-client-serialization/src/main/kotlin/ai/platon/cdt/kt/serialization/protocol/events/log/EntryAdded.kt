@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.log
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.log.LogEntry

/**
 * Issued when new message was logged.
 */
@Serializable
data class EntryAdded(
  @SerialName("entry")
  val entry: LogEntry,
)
