package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

public data class LoadEventFired(
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
)
