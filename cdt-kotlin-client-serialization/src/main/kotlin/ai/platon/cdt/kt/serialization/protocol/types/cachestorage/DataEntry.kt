@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Data entry.
 */
@Serializable
data class DataEntry(
  @SerialName("requestURL")
  val requestURL: String,
  @SerialName("requestMethod")
  val requestMethod: String,
  @SerialName("requestHeaders")
  val requestHeaders: List<Header>,
  @SerialName("responseTime")
  val responseTime: Double,
  @SerialName("responseStatus")
  val responseStatus: Int,
  @SerialName("responseStatusText")
  val responseStatusText: String,
  @SerialName("responseType")
  val responseType: CachedResponseType,
  @SerialName("responseHeaders")
  val responseHeaders: List<Header>,
)
