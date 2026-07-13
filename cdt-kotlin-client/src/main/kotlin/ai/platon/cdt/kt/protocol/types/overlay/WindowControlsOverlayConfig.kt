@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Configuration for Window Controls Overlay
 */
data class WindowControlsOverlayConfig(
  @param:JsonProperty("showCSS")
  val showCSS: Boolean,
  @param:JsonProperty("selectedPlatform")
  val selectedPlatform: String,
  @param:JsonProperty("themeColor")
  val themeColor: String,
)
