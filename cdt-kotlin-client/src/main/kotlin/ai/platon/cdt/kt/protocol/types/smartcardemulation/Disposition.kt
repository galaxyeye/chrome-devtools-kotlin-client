@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates what the reader should do with the card.
 */
public enum class Disposition {
  @JsonProperty("leave-card")
  LEAVE_CARD,
  @JsonProperty("reset-card")
  RESET_CARD,
  @JsonProperty("unpower-card")
  UNPOWER_CARD,
  @JsonProperty("eject-card")
  EJECT_CARD,
  @JsonEnumDefaultValue
  UNKNOWN,
}
