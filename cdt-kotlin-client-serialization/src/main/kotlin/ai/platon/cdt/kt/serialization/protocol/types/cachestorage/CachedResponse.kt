@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Cached response
 */
@Serializable
data class CachedResponse(
  @SerialName("body")
  val body: String,
)
