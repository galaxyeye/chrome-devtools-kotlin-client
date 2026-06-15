@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.serviceworker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.serviceworker.ServiceWorkerErrorMessage

@Serializable
data class WorkerErrorReported(
  @SerialName("errorMessage")
  val errorMessage: ServiceWorkerErrorMessage,
)
