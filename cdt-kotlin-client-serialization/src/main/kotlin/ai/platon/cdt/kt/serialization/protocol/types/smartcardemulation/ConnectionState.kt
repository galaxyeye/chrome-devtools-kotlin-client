@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Maps to |SCARD_*| connection state values.
 */
@Serializable
public enum class ConnectionState {
  @SerialName("absent")
  ABSENT,
  @SerialName("present")
  PRESENT,
  @SerialName("swallowed")
  SWALLOWED,
  @SerialName("powered")
  POWERED,
  @SerialName("negotiable")
  NEGOTIABLE,
  @SerialName("specific")
  SPECIFIC,
  UNKNOWN,
}
