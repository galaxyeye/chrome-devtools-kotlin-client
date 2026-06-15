@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class IPAddressSpace {
  // Patch: vincent, 20251025, protocol upgraded. Or you can modify the received message before deserialization.
  @SerialName("Loopback")
  LOOPBACK,

  @SerialName("Local")
  LOCAL,
  @SerialName("Private")
  PRIVATE,
  @SerialName("Public")
  PUBLIC,
  @SerialName("Unknown")
  UNKNOWN,
}
