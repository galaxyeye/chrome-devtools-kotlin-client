@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.serviceworker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.serviceworker.ServiceWorkerVersion
import kotlin.collections.List

@Serializable
data class WorkerVersionUpdated(
  @SerialName("versions")
  val versions: List<ServiceWorkerVersion>,
)
