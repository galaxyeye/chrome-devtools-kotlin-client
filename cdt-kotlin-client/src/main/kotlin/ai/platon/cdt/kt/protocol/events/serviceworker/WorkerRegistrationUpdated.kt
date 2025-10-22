package ai.platon.cdt.kt.protocol.events.serviceworker

import ai.platon.cdt.kt.protocol.types.serviceworker.ServiceWorkerRegistration
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class WorkerRegistrationUpdated(
  @field:JsonProperty("registrations")
  val registrations: List<ServiceWorkerRegistration>,
)
