@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String

@Experimental
data class DirectUDPSocketOptions(
  @param:JsonProperty("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @param:JsonProperty("remotePort")
  @param:Optional
  val remotePort: Int? = null,
  @param:JsonProperty("localAddr")
  @param:Optional
  val localAddr: String? = null,
  @param:JsonProperty("localPort")
  @param:Optional
  val localPort: Int? = null,
  @param:JsonProperty("dnsQueryType")
  @param:Optional
  val dnsQueryType: DirectSocketDnsQueryType? = null,
  @param:JsonProperty("sendBufferSize")
  @param:Optional
  val sendBufferSize: Double? = null,
  @param:JsonProperty("receiveBufferSize")
  @param:Optional
  val receiveBufferSize: Double? = null,
  @param:JsonProperty("multicastLoopback")
  @param:Optional
  val multicastLoopback: Boolean? = null,
  @param:JsonProperty("multicastTimeToLive")
  @param:Optional
  val multicastTimeToLive: Int? = null,
  @param:JsonProperty("multicastAllowAddressSharing")
  @param:Optional
  val multicastAllowAddressSharing: Boolean? = null,
)
