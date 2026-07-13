@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

@Experimental
data class DirectUDPMessage(
  @param:JsonProperty("data")
  val `data`: String,
  @param:JsonProperty("remoteAddr")
  @param:Optional
  val remoteAddr: String? = null,
  @param:JsonProperty("remotePort")
  @param:Optional
  val remotePort: Int? = null,
)
