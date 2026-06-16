@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration for Window Controls Overlay
 */
@Serializable
data class WindowControlsOverlayConfig(
  @property:SerialName("showCSS")
  val showCSS: Boolean,
  @property:SerialName("selectedPlatform")
  val selectedPlatform: String,
  @property:SerialName("themeColor")
  val themeColor: String,
)
