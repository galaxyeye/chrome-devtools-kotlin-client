@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Cache identifier.
 */
@Serializable
data class Cache(
  @SerialName("cacheId")
  val cacheId: String,
  @SerialName("securityOrigin")
  val securityOrigin: String,
  @SerialName("cacheName")
  val cacheName: String,
)
