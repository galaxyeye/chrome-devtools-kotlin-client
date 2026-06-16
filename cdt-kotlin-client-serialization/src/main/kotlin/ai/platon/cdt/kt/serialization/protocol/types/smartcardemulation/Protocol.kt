@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Maps to the |SCARD_PROTOCOL_*| values.
 */
@Serializable
public enum class Protocol {
  @SerialName("t0")
  T_0,
  @SerialName("t1")
  T_1,
  @SerialName("raw")
  RAW,
  UNKNOWN,
}
