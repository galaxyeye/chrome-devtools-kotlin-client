@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PressureSource {
  @SerialName("cpu")
  CPU,
  UNKNOWN,
}
