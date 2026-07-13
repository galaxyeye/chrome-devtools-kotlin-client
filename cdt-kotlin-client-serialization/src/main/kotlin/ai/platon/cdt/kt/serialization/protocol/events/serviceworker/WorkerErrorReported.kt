@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.serviceworker

import ai.platon.cdt.kt.serialization.protocol.types.serviceworker.ServiceWorkerErrorMessage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkerErrorReported(
  @property:SerialName("errorMessage")
  val errorMessage: ServiceWorkerErrorMessage,
)
