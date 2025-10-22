package ai.platon.cdt.kt.protocol.types.serviceworker

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * ServiceWorker version.
 */
data class ServiceWorkerVersion(
  @field:JsonProperty("versionId")
  val versionId: String,
  @field:JsonProperty("registrationId")
  val registrationId: String,
  @field:JsonProperty("scriptURL")
  val scriptURL: String,
  @field:JsonProperty("runningStatus")
  val runningStatus: ServiceWorkerVersionRunningStatus,
  @field:JsonProperty("status")
  val status: ServiceWorkerVersionStatus,
  @field:JsonProperty("scriptLastModified")
  @param:Optional
  val scriptLastModified: Double? = null,
  @field:JsonProperty("scriptResponseTime")
  @param:Optional
  val scriptResponseTime: Double? = null,
  @field:JsonProperty("controlledClients")
  @param:Optional
  val controlledClients: List<String>? = null,
  @field:JsonProperty("targetId")
  @param:Optional
  val targetId: String? = null,
)
