@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Corresponds to mojom::SpeculationTargetHint.
 * See https://github.com/WICG/nav-speculation/blob/main/triggers.md#window-name-targeting-hints
 */
public enum class SpeculationTargetHint {
  @JsonProperty("Blank")
  BLANK,
  @JsonProperty("Self")
  SELF,
  @JsonEnumDefaultValue
  UNKNOWN,
}
