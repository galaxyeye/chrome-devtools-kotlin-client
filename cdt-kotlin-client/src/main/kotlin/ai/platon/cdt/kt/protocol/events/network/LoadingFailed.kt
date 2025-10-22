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
public data class LoadingFailed(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("type")
  public val type: ResourceType,
  @field:JsonProperty("errorText")
  public val errorText: String,
  @field:JsonProperty("canceled")
  @param:Optional
  public val canceled: Boolean? = null,
  @field:JsonProperty("blockedReason")
  @param:Optional
  public val blockedReason: BlockedReason? = null,
  @field:JsonProperty("corsErrorStatus")
  @param:Optional
  public val corsErrorStatus: CorsErrorStatus? = null,
)
