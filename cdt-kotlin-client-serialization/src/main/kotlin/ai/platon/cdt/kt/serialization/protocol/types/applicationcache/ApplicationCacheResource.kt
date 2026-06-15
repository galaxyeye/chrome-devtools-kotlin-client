@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Detailed application cache resource information.
 */
@Serializable
data class ApplicationCacheResource(
  @SerialName("url")
  val url: String,
  @SerialName("size")
  val size: Int,
  @SerialName("type")
  val type: String,
)
