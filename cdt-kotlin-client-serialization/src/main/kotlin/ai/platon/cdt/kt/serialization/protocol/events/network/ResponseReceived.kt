@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import ai.platon.cdt.kt.serialization.protocol.types.network.Response
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP response is available.
 */
@Serializable
data class ResponseReceived(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("loaderId")
  val loaderId: String,
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("type")
  val type: ResourceType,
  @SerialName("response")
  val response: Response,
  @SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
)
