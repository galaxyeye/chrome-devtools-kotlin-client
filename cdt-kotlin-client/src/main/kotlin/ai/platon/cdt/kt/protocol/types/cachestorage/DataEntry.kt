package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Data entry.
 */
data class DataEntry(
  @field:JsonProperty("requestURL")
  val requestURL: String,
  @field:JsonProperty("requestMethod")
  val requestMethod: String,
  @field:JsonProperty("requestHeaders")
  val requestHeaders: List<Header>,
  @field:JsonProperty("responseTime")
  val responseTime: Double,
  @field:JsonProperty("responseStatus")
  val responseStatus: Int,
  @field:JsonProperty("responseStatusText")
  val responseStatusText: String,
  @field:JsonProperty("responseType")
  val responseType: CachedResponseType,
  @field:JsonProperty("responseHeaders")
  val responseHeaders: List<Header>,
)
