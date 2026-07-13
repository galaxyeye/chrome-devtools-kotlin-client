@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.serviceworker

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ServiceWorker version.
 */
@Serializable
data class ServiceWorkerVersion(
  @property:SerialName("versionId")
  val versionId: String,
  @property:SerialName("registrationId")
  val registrationId: String,
  @property:SerialName("scriptURL")
  val scriptURL: String,
  @property:SerialName("runningStatus")
  val runningStatus: ServiceWorkerVersionRunningStatus,
  @property:SerialName("status")
  val status: ServiceWorkerVersionStatus,
  @property:SerialName("scriptLastModified")
  @param:Optional
  val scriptLastModified: Double? = null,
  @property:SerialName("scriptResponseTime")
  @param:Optional
  val scriptResponseTime: Double? = null,
  @property:SerialName("controlledClients")
  @param:Optional
  val controlledClients: List<String>? = null,
  @property:SerialName("targetId")
  @param:Optional
  val targetId: String? = null,
  @property:SerialName("routerRules")
  @param:Optional
  val routerRules: String? = null,
)
