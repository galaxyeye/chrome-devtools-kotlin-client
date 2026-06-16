@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fedcm

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Triggered when a dialog is closed, either by user action, JS abort,
 * or a command below.
 */
@Serializable
data class DialogClosed(
  @property:SerialName("dialogId")
  val dialogId: String,
)
