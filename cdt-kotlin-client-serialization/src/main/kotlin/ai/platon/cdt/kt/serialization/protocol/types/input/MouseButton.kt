@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class MouseButton {
  @SerialName("none")
  NONE,
  @SerialName("left")
  LEFT,
  @SerialName("middle")
  MIDDLE,
  @SerialName("right")
  RIGHT,
  @SerialName("back")
  BACK,
  @SerialName("forward")
  FORWARD,
}
