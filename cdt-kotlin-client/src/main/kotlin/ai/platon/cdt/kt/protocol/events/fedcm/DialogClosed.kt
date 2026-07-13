@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.fedcm

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Triggered when a dialog is closed, either by user action, JS abort,
 * or a command below.
 */
data class DialogClosed(
  @param:JsonProperty("dialogId")
  val dialogId: String,
)
