@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to mojom::SpeculationTargetHint.
 * See https://github.com/WICG/nav-speculation/blob/main/triggers.md#window-name-targeting-hints
 */
@Serializable
public enum class SpeculationTargetHint {
  @SerialName("Blank")
  BLANK,
  @SerialName("Self")
  SELF,
  UNKNOWN,
}
