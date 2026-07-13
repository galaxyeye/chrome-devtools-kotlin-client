@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ContainerSelector physical axes
 */
@Serializable
public enum class PhysicalAxes {
  @SerialName("Horizontal")
  HORIZONTAL,
  @SerialName("Vertical")
  VERTICAL,
  @SerialName("Both")
  BOTH,
  UNKNOWN,
}
