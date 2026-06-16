@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.applicationcache

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Detailed application cache information.
 */
@Serializable
data class ApplicationCache(
  @property:SerialName("manifestURL")
  val manifestURL: String,
  @property:SerialName("size")
  val size: Double,
  @property:SerialName("creationTime")
  val creationTime: Double,
  @property:SerialName("updateTime")
  val updateTime: Double,
  @property:SerialName("resources")
  val resources: List<ApplicationCacheResource>,
)
