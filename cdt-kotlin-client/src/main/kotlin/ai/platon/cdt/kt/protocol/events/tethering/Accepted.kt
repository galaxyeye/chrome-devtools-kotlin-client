package ai.platon.cdt.kt.protocol.events.tethering

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Informs that port was successfully bound and got a specified connection id.
 */
data class Accepted(
  @field:JsonProperty("port")
  val port: Int,
  @field:JsonProperty("connectionId")
  val connectionId: String,
)
