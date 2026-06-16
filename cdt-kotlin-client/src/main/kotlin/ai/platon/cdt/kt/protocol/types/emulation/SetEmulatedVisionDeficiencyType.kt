@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Vision deficiency to emulate. Order: best-effort emulations come first, followed by any
 * physiologically accurate emulations for medically recognized color vision deficiencies.
 */
public enum class SetEmulatedVisionDeficiencyType {
  @JsonProperty("none")
  NONE,
  @JsonProperty("blurredVision")
  BLURRED_VISION,
  @JsonProperty("reducedContrast")
  REDUCED_CONTRAST,
  @JsonProperty("achromatopsia")
  ACHROMATOPSIA,
  @JsonProperty("deuteranopia")
  DEUTERANOPIA,
  @JsonProperty("protanopia")
  PROTANOPIA,
  @JsonProperty("tritanopia")
  TRITANOPIA,
  @JsonEnumDefaultValue
  UNKNOWN,
}
