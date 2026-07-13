@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates what the reader should do with the card.
 */
@Serializable
public enum class Disposition {
  @SerialName("leave-card")
  LEAVE_CARD,
  @SerialName("reset-card")
  RESET_CARD,
  @SerialName("unpower-card")
  UNPOWER_CARD,
  @SerialName("eject-card")
  EJECT_CARD,
  UNKNOWN,
}
