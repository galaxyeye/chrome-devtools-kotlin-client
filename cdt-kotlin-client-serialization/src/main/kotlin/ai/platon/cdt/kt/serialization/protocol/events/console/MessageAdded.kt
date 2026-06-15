@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.console
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.console.ConsoleMessage

/**
 * Issued when new console message is added.
 */
@Serializable
data class MessageAdded(
  @SerialName("message")
  val message: ConsoleMessage,
)
