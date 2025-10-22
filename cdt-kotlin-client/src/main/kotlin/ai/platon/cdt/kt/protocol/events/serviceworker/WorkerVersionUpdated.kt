package ai.platon.cdt.kt.protocol.events.serviceworker

import ai.platon.cdt.kt.protocol.types.serviceworker.ServiceWorkerVersion
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

data class WorkerVersionUpdated(
  @field:JsonProperty("versions")
  val versions: List<ServiceWorkerVersion>,
)
