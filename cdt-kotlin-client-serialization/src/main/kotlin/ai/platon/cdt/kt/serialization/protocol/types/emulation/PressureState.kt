@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PressureState {
  @SerialName("nominal")
  NOMINAL,
  @SerialName("fair")
  FAIR,
  @SerialName("serious")
  SERIOUS,
  @SerialName("critical")
  CRITICAL,
  UNKNOWN,
}
