@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Fired when a new window is going to be opened, via window.open(), link click, form submission,
 * etc.
 */
@Serializable
data class WindowOpen(
  @SerialName("url")
  val url: String,
  @SerialName("windowName")
  val windowName: String,
  @SerialName("windowFeatures")
  val windowFeatures: List<String>,
  @SerialName("userGesture")
  val userGesture: Boolean,
)
