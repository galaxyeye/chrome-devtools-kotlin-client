@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class InspectMode {
  @SerialName("searchForNode")
  SEARCH_FOR_NODE,
  @SerialName("searchForUAShadowDOM")
  SEARCH_FOR_UA_SHADOW_DOM,
  @SerialName("captureAreaScreenshot")
  CAPTURE_AREA_SCREENSHOT,
  @SerialName("none")
  NONE,
  UNKNOWN,
}
