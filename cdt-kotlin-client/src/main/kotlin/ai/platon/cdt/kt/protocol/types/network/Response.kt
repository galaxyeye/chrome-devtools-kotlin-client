package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.security.SecurityState
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * HTTP response data.
 */
public data class Response(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("status")
  public val status: Int,
  @field:JsonProperty("statusText")
  public val statusText: String,
  @field:JsonProperty("headers")
  public val headers: Map<String, Any?>,
  @field:JsonProperty("headersText")
  @param:Optional
  public val headersText: String? = null,
  @field:JsonProperty("mimeType")
  public val mimeType: String,
  @field:JsonProperty("requestHeaders")
  @param:Optional
  public val requestHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestHeadersText")
  @param:Optional
  public val requestHeadersText: String? = null,
  @field:JsonProperty("connectionReused")
  public val connectionReused: Boolean,
  @field:JsonProperty("connectionId")
  public val connectionId: Double,
  @field:JsonProperty("remoteIPAddress")
  @param:Optional
  public val remoteIPAddress: String? = null,
  @field:JsonProperty("remotePort")
  @param:Optional
  public val remotePort: Int? = null,
  @field:JsonProperty("fromDiskCache")
  @param:Optional
  public val fromDiskCache: Boolean? = null,
  @field:JsonProperty("fromServiceWorker")
  @param:Optional
  public val fromServiceWorker: Boolean? = null,
  @field:JsonProperty("fromPrefetchCache")
  @param:Optional
  public val fromPrefetchCache: Boolean? = null,
  @field:JsonProperty("encodedDataLength")
  public val encodedDataLength: Double,
  @field:JsonProperty("timing")
  @param:Optional
  public val timing: ResourceTiming? = null,
  @field:JsonProperty("serviceWorkerResponseSource")
  @param:Optional
  public val serviceWorkerResponseSource: ServiceWorkerResponseSource? = null,
  @field:JsonProperty("responseTime")
  @param:Optional
  public val responseTime: Double? = null,
  @field:JsonProperty("cacheStorageCacheName")
  @param:Optional
  public val cacheStorageCacheName: String? = null,
  @field:JsonProperty("protocol")
  @param:Optional
  public val protocol: String? = null,
  @field:JsonProperty("securityState")
  public val securityState: SecurityState,
  @field:JsonProperty("securityDetails")
  @param:Optional
  public val securityDetails: SecurityDetails? = null,
)
