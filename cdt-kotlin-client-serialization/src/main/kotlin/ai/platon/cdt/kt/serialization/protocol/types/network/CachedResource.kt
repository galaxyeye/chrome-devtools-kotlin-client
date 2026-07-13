@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the cached resource.
 */
@Serializable
data class CachedResource(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("type")
  val type: ResourceType,
  @property:SerialName("response")
  @param:Optional
  val response: Response? = null,
  @property:SerialName("bodySize")
  val bodySize: Double,
)
