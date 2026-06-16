@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Physical scroll orientation
 */
@Serializable
public enum class ScrollOrientation {
  @SerialName("horizontal")
  HORIZONTAL,
  @SerialName("vertical")
  VERTICAL,
  UNKNOWN,
}
