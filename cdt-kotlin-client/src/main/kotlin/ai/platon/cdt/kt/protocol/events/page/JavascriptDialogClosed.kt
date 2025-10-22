package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
 * closed.
 */
data class JavascriptDialogClosed(
  @field:JsonProperty("result")
  val result: Boolean,
  @field:JsonProperty("userInput")
  val userInput: String,
)
