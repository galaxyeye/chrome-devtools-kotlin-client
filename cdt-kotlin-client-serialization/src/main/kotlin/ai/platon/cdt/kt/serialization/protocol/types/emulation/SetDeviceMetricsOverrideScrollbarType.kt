@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Scrollbar type. Default: `default`.
 */
@Serializable
public enum class SetDeviceMetricsOverrideScrollbarType {
  @SerialName("overlay")
  OVERLAY,
  @SerialName("default")
  DEFAULT,
  UNKNOWN,
}
