package ai.platon.cdt.kt.protocol.types.backgroundservice

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

public data class BackgroundServiceEvent(
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("origin")
  public val origin: String,
  @field:JsonProperty("serviceWorkerRegistrationId")
  public val serviceWorkerRegistrationId: String,
  @field:JsonProperty("service")
  public val service: ServiceName,
  @field:JsonProperty("eventName")
  public val eventName: String,
  @field:JsonProperty("instanceId")
  public val instanceId: String,
  @field:JsonProperty("eventMetadata")
  public val eventMetadata: List<EventMetadata>,
)
