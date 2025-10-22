package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.TrustTokenOperationDoneStatus
import ai.platon.cdt.kt.protocol.types.network.TrustTokenOperationType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Fired exactly once for each Trust Token operation. Depending on
 * the type of the operation and whether the operation succeeded or
 * failed, the event is fired before the corresponding request was sent
 * or after the response was received.
 */
@Experimental
public data class TrustTokenOperationDone(
  @field:JsonProperty("status")
  public val status: TrustTokenOperationDoneStatus,
  @field:JsonProperty("type")
  public val type: TrustTokenOperationType,
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("topLevelOrigin")
  @param:Optional
  public val topLevelOrigin: String? = null,
  @field:JsonProperty("issuerOrigin")
  @param:Optional
  public val issuerOrigin: String? = null,
  @field:JsonProperty("issuedTokenCount")
  @param:Optional
  public val issuedTokenCount: Int? = null,
)
