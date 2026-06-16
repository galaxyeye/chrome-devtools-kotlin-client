@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DirectUDPSocketJoinedMulticastGroup(
  @property:SerialName("identifier")
  val identifier: String,
  @property:SerialName("IPAddress")
  val IPAddress: String,
)
