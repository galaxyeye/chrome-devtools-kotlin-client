@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ContainerSelector logical axes
 */
@Serializable
public enum class LogicalAxes {
  @SerialName("Inline")
  INLINE,
  @SerialName("Block")
  BLOCK,
  @SerialName("Both")
  BOTH,
  UNKNOWN,
}
