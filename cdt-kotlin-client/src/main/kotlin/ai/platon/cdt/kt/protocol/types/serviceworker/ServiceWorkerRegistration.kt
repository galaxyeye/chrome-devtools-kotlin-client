package ai.platon.cdt.kt.protocol.types.serviceworker

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * ServiceWorker registration.
 */
public data class ServiceWorkerRegistration(
  @field:JsonProperty("registrationId")
  public val registrationId: String,
  @field:JsonProperty("scopeURL")
  public val scopeURL: String,
  @field:JsonProperty("isDeleted")
  public val isDeleted: Boolean,
)
