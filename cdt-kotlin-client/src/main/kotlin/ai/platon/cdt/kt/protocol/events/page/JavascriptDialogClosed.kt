package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) has been
 * closed.
 */
public data class JavascriptDialogClosed(
  @field:JsonProperty("result")
  public val result: Boolean,
  @field:JsonProperty("userInput")
  public val userInput: String,
)
