@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ServiceWorker registration.
 */
@Serializable
data class ServiceWorkerRegistration(
  @property:SerialName("registrationId")
  val registrationId: String,
  @property:SerialName("scopeURL")
  val scopeURL: String,
  @property:SerialName("isDeleted")
  val isDeleted: Boolean,
)
