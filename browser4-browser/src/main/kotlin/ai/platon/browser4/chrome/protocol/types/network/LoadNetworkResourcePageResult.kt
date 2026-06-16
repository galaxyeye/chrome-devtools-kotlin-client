@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * An object providing the result of a network resource load.
 */
@Serializable
@Experimental
data class LoadNetworkResourcePageResult(
  @property:SerialName("success")
  val success: Boolean,
  @property:SerialName("netError")
  @param:Optional
  val netError: Double? = null,
  @property:SerialName("netErrorName")
  @param:Optional
  val netErrorName: String? = null,
  @property:SerialName("httpStatusCode")
  @param:Optional
  val httpStatusCode: Double? = null,
  @property:SerialName("stream")
  @param:Optional
  val stream: String? = null,
  @property:SerialName("headers")
  @param:Optional
  val headers: JsonObject? = null,
)
