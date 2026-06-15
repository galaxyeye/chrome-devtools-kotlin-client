@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityState
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.Map

/**
 * HTTP response data.
 */
@Serializable
data class Response(
  @SerialName("url")
  val url: String,
  @SerialName("status")
  val status: Int,
  @SerialName("statusText")
  val statusText: String,
  @SerialName("headers")
  val headers: Map<String, Any?>,
  @SerialName("headersText")
  @param:Optional
  val headersText: String? = null,
  @SerialName("mimeType")
  val mimeType: String,
  @SerialName("requestHeaders")
  @param:Optional
  val requestHeaders: Map<String, Any?>? = null,
  @SerialName("requestHeadersText")
  @param:Optional
  val requestHeadersText: String? = null,
  @SerialName("connectionReused")
  val connectionReused: Boolean,
  @SerialName("connectionId")
  val connectionId: Double,
  @SerialName("remoteIPAddress")
  @param:Optional
  val remoteIPAddress: String? = null,
  @SerialName("remotePort")
  @param:Optional
  val remotePort: Int? = null,
  @SerialName("fromDiskCache")
  @param:Optional
  val fromDiskCache: Boolean? = null,
  @SerialName("fromServiceWorker")
  @param:Optional
  val fromServiceWorker: Boolean? = null,
  @SerialName("fromPrefetchCache")
  @param:Optional
  val fromPrefetchCache: Boolean? = null,
  @SerialName("encodedDataLength")
  val encodedDataLength: Double,
  @SerialName("timing")
  @param:Optional
  val timing: ResourceTiming? = null,
  @SerialName("serviceWorkerResponseSource")
  @param:Optional
  val serviceWorkerResponseSource: ServiceWorkerResponseSource? = null,
  @SerialName("responseTime")
  @param:Optional
  val responseTime: Double? = null,
  @SerialName("cacheStorageCacheName")
  @param:Optional
  val cacheStorageCacheName: String? = null,
  @SerialName("protocol")
  @param:Optional
  val protocol: String? = null,
  @SerialName("securityState")
  val securityState: SecurityState,
  @SerialName("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
)
