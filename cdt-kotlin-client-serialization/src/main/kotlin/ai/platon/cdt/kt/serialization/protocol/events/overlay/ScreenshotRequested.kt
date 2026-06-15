@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.page.Viewport

/**
 * Fired when user asks to capture screenshot of some area on the page.
 */
@Serializable
data class ScreenshotRequested(
  @SerialName("viewport")
  val viewport: Viewport,
)
