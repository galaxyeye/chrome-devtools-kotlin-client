@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.cachestorage

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data entry.
 */
@Serializable
data class DataEntry(
  @property:SerialName("requestURL")
  val requestURL: String,
  @property:SerialName("requestMethod")
  val requestMethod: String,
  @property:SerialName("requestHeaders")
  val requestHeaders: List<Header>,
  @property:SerialName("responseTime")
  val responseTime: Double,
  @property:SerialName("responseStatus")
  val responseStatus: Int,
  @property:SerialName("responseStatusText")
  val responseStatusText: String,
  @property:SerialName("responseType")
  val responseType: CachedResponseType,
  @property:SerialName("responseHeaders")
  val responseHeaders: List<Header>,
)
