package ai.platon.cdt.kt.protocol.types.backgroundservice

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

data class BackgroundServiceEvent(
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("serviceWorkerRegistrationId")
  val serviceWorkerRegistrationId: String,
  @field:JsonProperty("service")
  val service: ServiceName,
  @field:JsonProperty("eventName")
  val eventName: String,
  @field:JsonProperty("instanceId")
  val instanceId: String,
  @field:JsonProperty("eventMetadata")
  val eventMetadata: List<EventMetadata>,
)
