@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.serviceworker

import ai.platon.cdt.kt.serialization.protocol.types.serviceworker.ServiceWorkerRegistration
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkerRegistrationUpdated(
  @property:SerialName("registrations")
  val registrations: List<ServiceWorkerRegistration>,
)
