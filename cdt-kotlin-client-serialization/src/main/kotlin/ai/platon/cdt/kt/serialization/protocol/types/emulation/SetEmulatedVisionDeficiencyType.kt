@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Vision deficiency to emulate.
 */
@Serializable
public enum class SetEmulatedVisionDeficiencyType {
  @SerialName("none")
  NONE,
  @SerialName("achromatopsia")
  ACHROMATOPSIA,
  @SerialName("blurredVision")
  BLURRED_VISION,
  @SerialName("deuteranopia")
  DEUTERANOPIA,
  @SerialName("protanopia")
  PROTANOPIA,
  @SerialName("tritanopia")
  TRITANOPIA,
}
