package ai.platon.cdt.kt.protocol.types.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Detailed application cache information.
 */
public data class ApplicationCache(
  @field:JsonProperty("manifestURL")
  public val manifestURL: String,
  @field:JsonProperty("size")
  public val size: Double,
  @field:JsonProperty("creationTime")
  public val creationTime: Double,
  @field:JsonProperty("updateTime")
  public val updateTime: Double,
  @field:JsonProperty("resources")
  public val resources: List<ApplicationCacheResource>,
)
