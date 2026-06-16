@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Loading priority of a resource request.
 */
@Serializable
public enum class ResourcePriority {
  @SerialName("VeryLow")
  VERY_LOW,
  @SerialName("Low")
  LOW,
  @SerialName("Medium")
  MEDIUM,
  @SerialName("High")
  HIGH,
  @SerialName("VeryHigh")
  VERY_HIGH,
  UNKNOWN,
}
