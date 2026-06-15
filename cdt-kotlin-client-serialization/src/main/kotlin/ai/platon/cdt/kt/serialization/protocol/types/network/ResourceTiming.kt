@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double

/**
 * Timing information for the request.
 */
@Serializable
data class ResourceTiming(
  @SerialName("requestTime")
  val requestTime: Double,
  @SerialName("proxyStart")
  val proxyStart: Double,
  @SerialName("proxyEnd")
  val proxyEnd: Double,
  @SerialName("dnsStart")
  val dnsStart: Double,
  @SerialName("dnsEnd")
  val dnsEnd: Double,
  @SerialName("connectStart")
  val connectStart: Double,
  @SerialName("connectEnd")
  val connectEnd: Double,
  @SerialName("sslStart")
  val sslStart: Double,
  @SerialName("sslEnd")
  val sslEnd: Double,
  @SerialName("workerStart")
  @param:Experimental
  val workerStart: Double,
  @SerialName("workerReady")
  @param:Experimental
  val workerReady: Double,
  @SerialName("workerFetchStart")
  @param:Experimental
  val workerFetchStart: Double,
  @SerialName("workerRespondWithSettled")
  @param:Experimental
  val workerRespondWithSettled: Double,
  @SerialName("sendStart")
  val sendStart: Double,
  @SerialName("sendEnd")
  val sendEnd: Double,
  @SerialName("pushStart")
  @param:Experimental
  val pushStart: Double,
  @SerialName("pushEnd")
  @param:Experimental
  val pushEnd: Double,
  @SerialName("receiveHeadersEnd")
  val receiveHeadersEnd: Double,
)
