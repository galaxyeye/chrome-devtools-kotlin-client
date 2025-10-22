package ai.platon.cdt.kt.protocol.types.cachestorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Data entry.
 */
public data class DataEntry(
  @field:JsonProperty("requestURL")
  public val requestURL: String,
  @field:JsonProperty("requestMethod")
  public val requestMethod: String,
  @field:JsonProperty("requestHeaders")
  public val requestHeaders: List<Header>,
  @field:JsonProperty("responseTime")
  public val responseTime: Double,
  @field:JsonProperty("responseStatus")
  public val responseStatus: Int,
  @field:JsonProperty("responseStatusText")
  public val responseStatusText: String,
  @field:JsonProperty("responseType")
  public val responseType: CachedResponseType,
  @field:JsonProperty("responseHeaders")
  public val responseHeaders: List<Header>,
)
