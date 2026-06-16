@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired if request ended up loading from cache.
 */
@Serializable
data class RequestServedFromCache(
  @property:SerialName("requestId")
  val requestId: String,
)
