@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.serviceworker

import ai.platon.cdt.kt.serialization.protocol.types.serviceworker.ServiceWorkerVersion
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WorkerVersionUpdated(
  @property:SerialName("versions")
  val versions: List<ServiceWorkerVersion>,
)
