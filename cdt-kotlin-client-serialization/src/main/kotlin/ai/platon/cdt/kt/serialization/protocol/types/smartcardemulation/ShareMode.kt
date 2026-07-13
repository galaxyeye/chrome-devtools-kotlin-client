@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Maps to the |SCARD_SHARE_*| values.
 */
@Serializable
public enum class ShareMode {
  @SerialName("shared")
  SHARED,
  @SerialName("exclusive")
  EXCLUSIVE,
  @SerialName("direct")
  DIRECT,
  UNKNOWN,
}
