@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
 * closed.
 */
@Serializable
data class JavascriptDialogClosed(
  @SerialName("result")
  val result: Boolean,
  @SerialName("userInput")
  val userInput: String,
)
