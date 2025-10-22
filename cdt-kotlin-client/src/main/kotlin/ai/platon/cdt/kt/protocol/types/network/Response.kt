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
data class Response(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("status")
  val status: Int,
  @field:JsonProperty("statusText")
  val statusText: String,
  @field:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @field:JsonProperty("headersText")
  @param:Optional
  val headersText: String? = null,
  @field:JsonProperty("mimeType")
  val mimeType: String,
  @field:JsonProperty("requestHeaders")
  @param:Optional
  val requestHeaders: Map<String, Any?>? = null,
  @field:JsonProperty("requestHeadersText")
  @param:Optional
  val requestHeadersText: String? = null,
  @field:JsonProperty("connectionReused")
  val connectionReused: Boolean,
  @field:JsonProperty("connectionId")
  val connectionId: Double,
  @field:JsonProperty("remoteIPAddress")
  @param:Optional
  val remoteIPAddress: String? = null,
  @field:JsonProperty("remotePort")
  @param:Optional
  val remotePort: Int? = null,
  @field:JsonProperty("fromDiskCache")
  @param:Optional
  val fromDiskCache: Boolean? = null,
  @field:JsonProperty("fromServiceWorker")
  @param:Optional
  val fromServiceWorker: Boolean? = null,
  @field:JsonProperty("fromPrefetchCache")
  @param:Optional
  val fromPrefetchCache: Boolean? = null,
  @field:JsonProperty("encodedDataLength")
  val encodedDataLength: Double,
  @field:JsonProperty("timing")
  @param:Optional
  val timing: ResourceTiming? = null,
  @field:JsonProperty("serviceWorkerResponseSource")
  @param:Optional
  val serviceWorkerResponseSource: ServiceWorkerResponseSource? = null,
  @field:JsonProperty("responseTime")
  @param:Optional
  val responseTime: Double? = null,
  @field:JsonProperty("cacheStorageCacheName")
  @param:Optional
  val cacheStorageCacheName: String? = null,
  @field:JsonProperty("protocol")
  @param:Optional
  val protocol: String? = null,
  @field:JsonProperty("securityState")
  val securityState: SecurityState,
  @field:JsonProperty("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
)
