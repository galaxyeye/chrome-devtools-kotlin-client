@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Detailed application cache information.
 */
@Serializable
data class ApplicationCache(
  @SerialName("manifestURL")
  val manifestURL: String,
  @SerialName("size")
  val size: Double,
  @SerialName("creationTime")
  val creationTime: Double,
  @SerialName("updateTime")
  val updateTime: Double,
  @SerialName("resources")
  val resources: List<ApplicationCacheResource>,
)
