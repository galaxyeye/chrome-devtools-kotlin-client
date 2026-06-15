@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

/**
 * ServiceWorker registration.
 */
@Serializable
data class ServiceWorkerRegistration(
  @SerialName("registrationId")
  val registrationId: String,
  @SerialName("scopeURL")
  val scopeURL: String,
  @SerialName("isDeleted")
  val isDeleted: Boolean,
)
