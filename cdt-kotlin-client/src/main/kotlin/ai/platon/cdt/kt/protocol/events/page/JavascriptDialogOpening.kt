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
public data class JavascriptDialogOpening(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("message")
  public val message: String,
  @field:JsonProperty("type")
  public val type: DialogType,
  @field:JsonProperty("hasBrowserHandler")
  public val hasBrowserHandler: Boolean,
  @field:JsonProperty("defaultPrompt")
  @param:Optional
  public val defaultPrompt: String? = null,
)
