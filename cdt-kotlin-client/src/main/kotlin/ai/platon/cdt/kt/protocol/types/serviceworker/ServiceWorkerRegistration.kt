package ai.platon.cdt.kt.protocol.types.serviceworker

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * ServiceWorker registration.
 */
data class ServiceWorkerRegistration(
  @field:JsonProperty("registrationId")
  val registrationId: String,
  @field:JsonProperty("scopeURL")
  val scopeURL: String,
  @field:JsonProperty("isDeleted")
  val isDeleted: Boolean,
)
