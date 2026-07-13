@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Cached response
 */
@Serializable
data class CachedResponse(
  @property:SerialName("body")
  val body: String,
)
