@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

/**
 * Information about the cached resource.
 */
@Serializable
data class CachedResource(
  @SerialName("url")
  val url: String,
  @SerialName("type")
  val type: ResourceType,
  @SerialName("response")
  @param:Optional
  val response: Response? = null,
  @SerialName("bodySize")
  val bodySize: Double,
)
