@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class IPAddressSpace {
  @SerialName("Local")
  LOCAL,
  @SerialName("Private")
  PRIVATE,
  @SerialName("Public")
  PUBLIC,
  @SerialName("Unknown")
  UNKNOWN,
}
