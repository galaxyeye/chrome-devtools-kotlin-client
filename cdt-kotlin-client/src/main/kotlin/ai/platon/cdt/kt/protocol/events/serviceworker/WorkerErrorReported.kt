package ai.platon.cdt.kt.protocol.events.serviceworker

import ai.platon.cdt.kt.protocol.types.serviceworker.ServiceWorkerErrorMessage
import com.fasterxml.jackson.`annotation`.JsonProperty

data class WorkerErrorReported(
  @field:JsonProperty("errorMessage")
  val errorMessage: ServiceWorkerErrorMessage,
)
