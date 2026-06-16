@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.TrustTokenOperationDoneStatus
import ai.platon.cdt.kt.serialization.protocol.types.network.TrustTokenOperationType
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired exactly once for each Trust Token operation. Depending on
 * the type of the operation and whether the operation succeeded or
 * failed, the event is fired before the corresponding request was sent
 * or after the response was received.
 */
@Serializable
@Experimental
data class TrustTokenOperationDone(
  @property:SerialName("status")
  val status: TrustTokenOperationDoneStatus,
  @property:SerialName("type")
  val type: TrustTokenOperationType,
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("topLevelOrigin")
  @param:Optional
  val topLevelOrigin: String? = null,
  @property:SerialName("issuerOrigin")
  @param:Optional
  val issuerOrigin: String? = null,
  @property:SerialName("issuedTokenCount")
  @param:Optional
  val issuedTokenCount: Int? = null,
)
