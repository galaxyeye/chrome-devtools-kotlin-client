@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Fired if request ended up loading from cache.
 */
@Serializable
data class RequestServedFromCache(
  @SerialName("requestId")
  val requestId: String,
)
