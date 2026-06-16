@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class GestureSourceType {
  @SerialName("default")
  DEFAULT,
  @SerialName("touch")
  TOUCH,
  @SerialName("mouse")
  MOUSE,
  UNKNOWN,
}
