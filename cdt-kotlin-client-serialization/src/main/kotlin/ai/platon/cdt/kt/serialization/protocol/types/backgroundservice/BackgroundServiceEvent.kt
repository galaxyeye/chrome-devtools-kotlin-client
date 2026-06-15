@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.backgroundservice
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String
import kotlin.collections.List

@Serializable
data class BackgroundServiceEvent(
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("origin")
  val origin: String,
  @SerialName("serviceWorkerRegistrationId")
  val serviceWorkerRegistrationId: String,
  @SerialName("service")
  val service: ServiceName,
  @SerialName("eventName")
  val eventName: String,
  @SerialName("instanceId")
  val instanceId: String,
  @SerialName("eventMetadata")
  val eventMetadata: List<EventMetadata>,
)
