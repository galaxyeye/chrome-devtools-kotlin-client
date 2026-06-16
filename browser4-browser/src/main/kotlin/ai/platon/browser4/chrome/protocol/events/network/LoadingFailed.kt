@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.network

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.BlockedReason
import ai.platon.browser4.chrome.protocol.types.network.CorsErrorStatus
import ai.platon.browser4.chrome.protocol.types.network.ResourceType
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when HTTP request has failed to load.
 */
@Serializable
data class LoadingFailed(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("type")
  val type: ResourceType,
  @property:SerialName("errorText")
  val errorText: String,
  @property:SerialName("canceled")
  @param:Optional
  val canceled: Boolean? = null,
  @property:SerialName("blockedReason")
  @param:Optional
  val blockedReason: BlockedReason? = null,
  @property:SerialName("corsErrorStatus")
  @param:Optional
  val corsErrorStatus: CorsErrorStatus? = null,
)
