package ai.platon.cdt.kt.protocol.types.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Detailed application cache information.
 */
data class ApplicationCache(
  @field:JsonProperty("manifestURL")
  val manifestURL: String,
  @field:JsonProperty("size")
  val size: Double,
  @field:JsonProperty("creationTime")
  val creationTime: Double,
  @field:JsonProperty("updateTime")
  val updateTime: Double,
  @field:JsonProperty("resources")
  val resources: List<ApplicationCacheResource>,
)
