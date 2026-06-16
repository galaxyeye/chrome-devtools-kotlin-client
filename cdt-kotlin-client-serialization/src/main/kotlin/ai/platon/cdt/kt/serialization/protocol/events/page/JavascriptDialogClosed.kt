@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
 * closed.
 */
@Serializable
data class JavascriptDialogClosed(
  @property:SerialName("result")
  val result: Boolean,
  @property:SerialName("userInput")
  val userInput: String,
)
