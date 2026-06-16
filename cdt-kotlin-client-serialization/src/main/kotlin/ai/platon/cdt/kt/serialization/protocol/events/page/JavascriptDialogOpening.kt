@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.page.DialogType
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a JavaScript initiated dialog (alert, confirm, prompt, or onbeforeunload) is about to
 * open.
 */
@Serializable
data class JavascriptDialogOpening(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("frameId")
  @param:Experimental
  val frameId: String,
  @property:SerialName("message")
  val message: String,
  @property:SerialName("type")
  val type: DialogType,
  @property:SerialName("hasBrowserHandler")
  val hasBrowserHandler: Boolean,
  @property:SerialName("defaultPrompt")
  @param:Optional
  val defaultPrompt: String? = null,
)
