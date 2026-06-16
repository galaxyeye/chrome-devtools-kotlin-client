@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.backgroundservice

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BackgroundServiceEvent(
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("serviceWorkerRegistrationId")
  val serviceWorkerRegistrationId: String,
  @property:SerialName("service")
  val service: ServiceName,
  @property:SerialName("eventName")
  val eventName: String,
  @property:SerialName("instanceId")
  val instanceId: String,
  @property:SerialName("eventMetadata")
  val eventMetadata: List<EventMetadata>,
)
