package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.BlockedReason
import ai.platon.cdt.kt.protocol.types.network.CorsErrorStatus
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has failed to load.
 */
data class LoadingFailed(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("type")
  val type: ResourceType,
  @field:JsonProperty("errorText")
  val errorText: String,
  @field:JsonProperty("canceled")
  @param:Optional
  val canceled: Boolean? = null,
  @field:JsonProperty("blockedReason")
  @param:Optional
  val blockedReason: BlockedReason? = null,
  @field:JsonProperty("corsErrorStatus")
  @param:Optional
  val corsErrorStatus: CorsErrorStatus? = null,
)
