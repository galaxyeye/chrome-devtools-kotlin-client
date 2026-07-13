@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.security.SecurityState
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * HTTP response data.
 */
@Serializable
data class Response(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("status")
  val status: Int,
  @property:SerialName("statusText")
  val statusText: String,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("headersText")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val headersText: String? = null,
  @property:SerialName("mimeType")
  val mimeType: String,
  @property:SerialName("charset")
  val charset: String,
  @property:SerialName("requestHeaders")
  @param:Optional
  val requestHeaders: JsonObject? = null,
  @property:SerialName("requestHeadersText")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val requestHeadersText: String? = null,
  @property:SerialName("connectionReused")
  val connectionReused: Boolean,
  @property:SerialName("connectionId")
  val connectionId: Double,
  @property:SerialName("remoteIPAddress")
  @param:Optional
  val remoteIPAddress: String? = null,
  @property:SerialName("remotePort")
  @param:Optional
  val remotePort: Int? = null,
  @property:SerialName("fromDiskCache")
  @param:Optional
  val fromDiskCache: Boolean? = null,
  @property:SerialName("fromServiceWorker")
  @param:Optional
  val fromServiceWorker: Boolean? = null,
  @property:SerialName("fromPrefetchCache")
  @param:Optional
  val fromPrefetchCache: Boolean? = null,
  @property:SerialName("fromEarlyHints")
  @param:Optional
  val fromEarlyHints: Boolean? = null,
  @property:SerialName("serviceWorkerRouterInfo")
  @param:Optional
  @param:Experimental
  val serviceWorkerRouterInfo: ServiceWorkerRouterInfo? = null,
  @property:SerialName("encodedDataLength")
  val encodedDataLength: Double,
  @property:SerialName("timing")
  @param:Optional
  val timing: ResourceTiming? = null,
  @property:SerialName("serviceWorkerResponseSource")
  @param:Optional
  val serviceWorkerResponseSource: ServiceWorkerResponseSource? = null,
  @property:SerialName("responseTime")
  @param:Optional
  val responseTime: Double? = null,
  @property:SerialName("cacheStorageCacheName")
  @param:Optional
  val cacheStorageCacheName: String? = null,
  @property:SerialName("protocol")
  @param:Optional
  val protocol: String? = null,
  @property:SerialName("alternateProtocolUsage")
  @param:Optional
  @param:Experimental
  val alternateProtocolUsage: AlternateProtocolUsage? = null,
  @property:SerialName("securityState")
  val securityState: SecurityState,
  @property:SerialName("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
)
