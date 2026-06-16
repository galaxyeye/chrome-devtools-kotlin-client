@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed application cache resource information.
 */
@Serializable
data class ApplicationCacheResource(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("size")
  val size: Int,
  @property:SerialName("type")
  val type: String,
)
