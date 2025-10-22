package ai.platon.cdt.kt.protocol.events.tethering

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Informs that port was successfully bound and got a specified connection id.
 */
public data class Accepted(
  @field:JsonProperty("port")
  public val port: Int,
  @field:JsonProperty("connectionId")
  public val connectionId: String,
)
