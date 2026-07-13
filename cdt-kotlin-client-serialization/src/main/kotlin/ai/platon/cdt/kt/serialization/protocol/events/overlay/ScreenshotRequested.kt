@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay

import ai.platon.cdt.kt.serialization.protocol.types.page.Viewport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when user asks to capture screenshot of some area on the page.
 */
@Serializable
data class ScreenshotRequested(
  @property:SerialName("viewport")
  val viewport: Viewport,
)
