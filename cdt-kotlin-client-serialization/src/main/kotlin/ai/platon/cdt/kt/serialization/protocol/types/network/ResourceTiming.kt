@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Timing information for the request.
 */
@Serializable
data class ResourceTiming(
  @property:SerialName("requestTime")
  val requestTime: Double,
  @property:SerialName("proxyStart")
  val proxyStart: Double,
  @property:SerialName("proxyEnd")
  val proxyEnd: Double,
  @property:SerialName("dnsStart")
  val dnsStart: Double,
  @property:SerialName("dnsEnd")
  val dnsEnd: Double,
  @property:SerialName("connectStart")
  val connectStart: Double,
  @property:SerialName("connectEnd")
  val connectEnd: Double,
  @property:SerialName("sslStart")
  val sslStart: Double,
  @property:SerialName("sslEnd")
  val sslEnd: Double,
  @property:SerialName("workerStart")
  @param:Experimental
  val workerStart: Double,
  @property:SerialName("workerReady")
  @param:Experimental
  val workerReady: Double,
  @property:SerialName("workerFetchStart")
  @param:Experimental
  val workerFetchStart: Double,
  @property:SerialName("workerRespondWithSettled")
  @param:Experimental
  val workerRespondWithSettled: Double,
  @property:SerialName("workerRouterEvaluationStart")
  @param:Optional
  @param:Experimental
  val workerRouterEvaluationStart: Double? = null,
  @property:SerialName("workerCacheLookupStart")
  @param:Optional
  @param:Experimental
  val workerCacheLookupStart: Double? = null,
  @property:SerialName("sendStart")
  val sendStart: Double,
  @property:SerialName("sendEnd")
  val sendEnd: Double,
  @property:SerialName("pushStart")
  @param:Experimental
  val pushStart: Double,
  @property:SerialName("pushEnd")
  @param:Experimental
  val pushEnd: Double,
  @property:SerialName("receiveHeadersStart")
  @param:Experimental
  val receiveHeadersStart: Double,
  @property:SerialName("receiveHeadersEnd")
  val receiveHeadersEnd: Double,
)
