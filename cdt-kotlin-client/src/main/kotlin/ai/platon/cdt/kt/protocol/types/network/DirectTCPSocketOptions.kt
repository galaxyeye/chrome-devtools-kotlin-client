@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double

@Experimental
data class DirectTCPSocketOptions(
  @param:JsonProperty("noDelay")
  val noDelay: Boolean,
  @param:JsonProperty("keepAliveDelay")
  @param:Optional
  val keepAliveDelay: Double? = null,
  @param:JsonProperty("sendBufferSize")
  @param:Optional
  val sendBufferSize: Double? = null,
  @param:JsonProperty("receiveBufferSize")
  @param:Optional
  val receiveBufferSize: Double? = null,
  @param:JsonProperty("dnsQueryType")
  @param:Optional
  val dnsQueryType: DirectSocketDnsQueryType? = null,
)
