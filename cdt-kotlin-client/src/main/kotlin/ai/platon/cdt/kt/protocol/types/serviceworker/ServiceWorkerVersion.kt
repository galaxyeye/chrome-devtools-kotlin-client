package ai.platon.cdt.kt.protocol.types.serviceworker

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * ServiceWorker version.
 */
public data class ServiceWorkerVersion(
  @field:JsonProperty("versionId")
  public val versionId: String,
  @field:JsonProperty("registrationId")
  public val registrationId: String,
  @field:JsonProperty("scriptURL")
  public val scriptURL: String,
  @field:JsonProperty("runningStatus")
  public val runningStatus: ServiceWorkerVersionRunningStatus,
  @field:JsonProperty("status")
  public val status: ServiceWorkerVersionStatus,
  @field:JsonProperty("scriptLastModified")
  @param:Optional
  public val scriptLastModified: Double? = null,
  @field:JsonProperty("scriptResponseTime")
  @param:Optional
  public val scriptResponseTime: Double? = null,
  @field:JsonProperty("controlledClients")
  @param:Optional
  public val controlledClients: List<String>? = null,
  @field:JsonProperty("targetId")
  @param:Optional
  public val targetId: String? = null,
)
