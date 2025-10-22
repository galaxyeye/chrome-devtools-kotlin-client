package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Timing information for the request.
 */
data class ResourceTiming(
  @field:JsonProperty("requestTime")
  val requestTime: Double,
  @field:JsonProperty("proxyStart")
  val proxyStart: Double,
  @field:JsonProperty("proxyEnd")
  val proxyEnd: Double,
  @field:JsonProperty("dnsStart")
  val dnsStart: Double,
  @field:JsonProperty("dnsEnd")
  val dnsEnd: Double,
  @field:JsonProperty("connectStart")
  val connectStart: Double,
  @field:JsonProperty("connectEnd")
  val connectEnd: Double,
  @field:JsonProperty("sslStart")
  val sslStart: Double,
  @field:JsonProperty("sslEnd")
  val sslEnd: Double,
  @field:JsonProperty("workerStart")
  @param:Experimental
  val workerStart: Double,
  @field:JsonProperty("workerReady")
  @param:Experimental
  val workerReady: Double,
  @field:JsonProperty("workerFetchStart")
  @param:Experimental
  val workerFetchStart: Double,
  @field:JsonProperty("workerRespondWithSettled")
  @param:Experimental
  val workerRespondWithSettled: Double,
  @field:JsonProperty("sendStart")
  val sendStart: Double,
  @field:JsonProperty("sendEnd")
  val sendEnd: Double,
  @field:JsonProperty("pushStart")
  @param:Experimental
  val pushStart: Double,
  @field:JsonProperty("pushEnd")
  @param:Experimental
  val pushEnd: Double,
  @field:JsonProperty("receiveHeadersEnd")
  val receiveHeadersEnd: Double,
)
