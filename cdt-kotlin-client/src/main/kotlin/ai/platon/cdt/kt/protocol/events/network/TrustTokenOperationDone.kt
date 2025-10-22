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
data class TrustTokenOperationDone(
  @field:JsonProperty("status")
  val status: TrustTokenOperationDoneStatus,
  @field:JsonProperty("type")
  val type: TrustTokenOperationType,
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("topLevelOrigin")
  @param:Optional
  val topLevelOrigin: String? = null,
  @field:JsonProperty("issuerOrigin")
  @param:Optional
  val issuerOrigin: String? = null,
  @field:JsonProperty("issuedTokenCount")
  @param:Optional
  val issuedTokenCount: Int? = null,
)
