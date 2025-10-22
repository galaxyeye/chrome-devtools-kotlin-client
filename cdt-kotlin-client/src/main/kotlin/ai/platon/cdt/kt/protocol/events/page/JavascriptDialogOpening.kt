package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.page.DialogType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
 * open.
 */
data class JavascriptDialogOpening(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("message")
  val message: String,
  @field:JsonProperty("type")
  val type: DialogType,
  @field:JsonProperty("hasBrowserHandler")
  val hasBrowserHandler: Boolean,
  @field:JsonProperty("defaultPrompt")
  @param:Optional
  val defaultPrompt: String? = null,
)
