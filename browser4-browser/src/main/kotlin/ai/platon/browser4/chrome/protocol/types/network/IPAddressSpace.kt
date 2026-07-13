@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class IPAddressSpace {
  @SerialName("Loopback")
  LOOPBACK,
  @SerialName("Local")
  LOCAL,
  @SerialName("Public")
  PUBLIC,
  @SerialName("Unknown")
  UNKNOWN,
}
