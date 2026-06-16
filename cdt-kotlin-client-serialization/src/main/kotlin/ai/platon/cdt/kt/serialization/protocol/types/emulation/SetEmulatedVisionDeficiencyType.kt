@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Vision deficiency to emulate. Order: best-effort emulations come first, followed by any
 * physiologically accurate emulations for medically recognized color vision deficiencies.
 */
@Serializable
public enum class SetEmulatedVisionDeficiencyType {
  @SerialName("none")
  NONE,
  @SerialName("blurredVision")
  BLURRED_VISION,
  @SerialName("reducedContrast")
  REDUCED_CONTRAST,
  @SerialName("achromatopsia")
  ACHROMATOPSIA,
  @SerialName("deuteranopia")
  DEUTERANOPIA,
  @SerialName("protanopia")
  PROTANOPIA,
  @SerialName("tritanopia")
  TRITANOPIA,
  UNKNOWN,
}
