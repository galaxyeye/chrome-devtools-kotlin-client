@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.BlockedReason
import ai.platon.cdt.kt.serialization.protocol.types.network.CorsErrorStatus
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has failed to load.
 */
@Serializable
data class LoadingFailed(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("type")
  val type: ResourceType,
  @SerialName("errorText")
  val errorText: String,
  @SerialName("canceled")
  @param:Optional
  val canceled: Boolean? = null,
  @SerialName("blockedReason")
  @param:Optional
  val blockedReason: BlockedReason? = null,
  @SerialName("corsErrorStatus")
  @param:Optional
  val corsErrorStatus: CorsErrorStatus? = null,
)
