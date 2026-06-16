@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Image compression format (defaults to png).
 */
@Serializable
public enum class CaptureScreenshotFormat {
  @SerialName("jpeg")
  JPEG,
  @SerialName("png")
  PNG,
  @SerialName("webp")
  WEBP,
  UNKNOWN,
}
