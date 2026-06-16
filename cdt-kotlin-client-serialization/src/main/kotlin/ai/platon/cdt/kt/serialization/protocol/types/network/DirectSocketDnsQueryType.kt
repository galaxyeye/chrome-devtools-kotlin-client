@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class DirectSocketDnsQueryType {
  @SerialName("ipv4")
  IPV_4,
  @SerialName("ipv6")
  IPV_6,
  UNKNOWN,
}
