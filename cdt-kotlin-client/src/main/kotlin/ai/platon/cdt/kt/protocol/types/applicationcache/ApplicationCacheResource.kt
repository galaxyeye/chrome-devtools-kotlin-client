package ai.platon.cdt.kt.protocol.types.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Detailed application cache resource information.
 */
data class ApplicationCacheResource(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("size")
  val size: Int,
  @field:JsonProperty("type")
  val type: String,
)
