@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.page.DialogType
import kotlin.Boolean
import kotlin.String

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
 * open.
 */
@Serializable
data class JavascriptDialogOpening(
  @SerialName("url")
  val url: String,
  @SerialName("message")
  val message: String,
  @SerialName("type")
  val type: DialogType,
  @SerialName("hasBrowserHandler")
  val hasBrowserHandler: Boolean,
  @SerialName("defaultPrompt")
  @param:Optional
  val defaultPrompt: String? = null,
)
