@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.headlessexperimental

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Image compression format (defaults to png).
 */
@Serializable
public enum class ScreenshotParamsFormat {
  @SerialName("jpeg")
  JPEG,
  @SerialName("png")
  PNG,
  UNKNOWN,
}
