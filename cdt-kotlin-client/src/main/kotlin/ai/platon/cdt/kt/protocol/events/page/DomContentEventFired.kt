package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

data class DomContentEventFired(
  @field:JsonProperty("timestamp")
  val timestamp: Double,
)
