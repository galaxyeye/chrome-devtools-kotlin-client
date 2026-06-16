@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.events.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.network.ResourceType
import ai.platon.browser4.chrome.protocol.types.network.Response
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when HTTP response is available.
 */
@Serializable
data class ResponseReceived(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("type")
  val type: ResourceType,
  @property:SerialName("response")
  val response: Response,
  @property:SerialName("hasExtraInfo")
  @param:Experimental
  val hasExtraInfo: Boolean,
  @property:SerialName("frameId")
  @param:Optional
  val frameId: String? = null,
)
