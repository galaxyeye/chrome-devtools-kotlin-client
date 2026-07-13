@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class DirectUDPSocketJoinedMulticastGroup(
  @param:JsonProperty("identifier")
  val identifier: String,
  @param:JsonProperty("IPAddress")
  val IPAddress: String,
)
