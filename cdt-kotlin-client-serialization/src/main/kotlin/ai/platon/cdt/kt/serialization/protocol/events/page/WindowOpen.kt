@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a new window is going to be opened, via window.open(), link click, form submission,
 * etc.
 */
@Serializable
data class WindowOpen(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("windowName")
  val windowName: String,
  @property:SerialName("windowFeatures")
  val windowFeatures: List<String>,
  @property:SerialName("userGesture")
  val userGesture: Boolean,
)
