@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.console

import ai.platon.cdt.kt.serialization.protocol.types.console.ConsoleMessage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when new console message is added.
 */
@Serializable
data class MessageAdded(
  @property:SerialName("message")
  val message: ConsoleMessage,
)
