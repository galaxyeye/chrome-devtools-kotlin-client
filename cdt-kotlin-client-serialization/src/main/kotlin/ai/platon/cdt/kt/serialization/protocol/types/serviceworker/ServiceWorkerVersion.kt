@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * ServiceWorker version.
 */
@Serializable
data class ServiceWorkerVersion(
  @SerialName("versionId")
  val versionId: String,
  @SerialName("registrationId")
  val registrationId: String,
  @SerialName("scriptURL")
  val scriptURL: String,
  @SerialName("runningStatus")
  val runningStatus: ServiceWorkerVersionRunningStatus,
  @SerialName("status")
  val status: ServiceWorkerVersionStatus,
  @SerialName("scriptLastModified")
  @param:Optional
  val scriptLastModified: Double? = null,
  @SerialName("scriptResponseTime")
  @param:Optional
  val scriptResponseTime: Double? = null,
  @SerialName("controlledClients")
  @param:Optional
  val controlledClients: List<String>? = null,
  @SerialName("targetId")
  @param:Optional
  val targetId: String? = null,
)
