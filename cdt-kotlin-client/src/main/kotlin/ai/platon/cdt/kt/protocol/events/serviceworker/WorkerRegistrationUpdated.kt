package ai.platon.cdt.kt.protocol.events.serviceworker

import ai.platon.cdt.kt.protocol.types.serviceworker.ServiceWorkerRegistration
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

public data class WorkerRegistrationUpdated(
  @field:JsonProperty("registrations")
  public val registrations: List<ServiceWorkerRegistration>,
)
