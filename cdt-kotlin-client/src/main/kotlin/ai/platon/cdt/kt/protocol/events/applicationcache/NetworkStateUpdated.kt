package ai.platon.cdt.kt.protocol.events.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

data class NetworkStateUpdated(
  @field:JsonProperty("isNowOnline")
  val isNowOnline: Boolean,
)
