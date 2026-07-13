@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DirectUDPMessage(
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @property:SerialName("remotePort")
  @param:Optional
  val remotePort: Int? = null,
)
