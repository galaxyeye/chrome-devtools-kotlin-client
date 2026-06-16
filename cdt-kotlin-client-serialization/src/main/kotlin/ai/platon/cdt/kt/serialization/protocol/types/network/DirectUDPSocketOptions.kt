@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DirectUDPSocketOptions(
  @property:SerialName("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @property:SerialName("remotePort")
  @param:Optional
  val remotePort: Int? = null,
  @property:SerialName("localAddr")
  @param:Optional
  val localAddr: String? = null,
  @property:SerialName("localPort")
  @param:Optional
  val localPort: Int? = null,
  @property:SerialName("dnsQueryType")
  @param:Optional
  val dnsQueryType: DirectSocketDnsQueryType? = null,
  @property:SerialName("sendBufferSize")
  @param:Optional
  val sendBufferSize: Double? = null,
  @property:SerialName("receiveBufferSize")
  @param:Optional
  val receiveBufferSize: Double? = null,
  @property:SerialName("multicastLoopback")
  @param:Optional
  val multicastLoopback: Boolean? = null,
  @property:SerialName("multicastTimeToLive")
  @param:Optional
  val multicastTimeToLive: Int? = null,
  @property:SerialName("multicastAllowAddressSharing")
  @param:Optional
  val multicastAllowAddressSharing: Boolean? = null,
)
