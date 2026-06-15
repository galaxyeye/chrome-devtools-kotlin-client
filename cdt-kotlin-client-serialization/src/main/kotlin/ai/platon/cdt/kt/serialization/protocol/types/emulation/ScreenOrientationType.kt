@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Orientation type.
 */
@Serializable
public enum class ScreenOrientationType {
  @SerialName("portraitPrimary")
  PORTRAIT_PRIMARY,
  @SerialName("portraitSecondary")
  PORTRAIT_SECONDARY,
  @SerialName("landscapePrimary")
  LANDSCAPE_PRIMARY,
  @SerialName("landscapeSecondary")
  LANDSCAPE_SECONDARY,
}
