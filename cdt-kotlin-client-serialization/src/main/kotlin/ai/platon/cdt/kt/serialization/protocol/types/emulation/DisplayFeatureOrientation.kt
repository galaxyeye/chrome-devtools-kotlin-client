@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Orientation of a display feature in relation to screen
 */
@Serializable
public enum class DisplayFeatureOrientation {
  @SerialName("vertical")
  VERTICAL,
  @SerialName("horizontal")
  HORIZONTAL,
}
