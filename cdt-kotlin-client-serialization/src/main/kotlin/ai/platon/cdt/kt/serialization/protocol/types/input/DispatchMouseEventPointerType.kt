@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pointer type (default: "mouse").
 */
@Serializable
public enum class DispatchMouseEventPointerType {
  @SerialName("mouse")
  MOUSE,
  @SerialName("pen")
  PEN,
  UNKNOWN,
}
