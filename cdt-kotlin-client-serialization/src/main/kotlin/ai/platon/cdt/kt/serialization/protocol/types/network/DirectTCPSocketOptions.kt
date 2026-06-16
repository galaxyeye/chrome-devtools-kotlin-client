@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DirectTCPSocketOptions(
  @property:SerialName("noDelay")
  val noDelay: Boolean,
  @property:SerialName("keepAliveDelay")
  @param:Optional
  val keepAliveDelay: Double? = null,
  @property:SerialName("sendBufferSize")
  @param:Optional
  val sendBufferSize: Double? = null,
  @property:SerialName("receiveBufferSize")
  @param:Optional
  val receiveBufferSize: Double? = null,
  @property:SerialName("dnsQueryType")
  @param:Optional
  val dnsQueryType: DirectSocketDnsQueryType? = null,
)
