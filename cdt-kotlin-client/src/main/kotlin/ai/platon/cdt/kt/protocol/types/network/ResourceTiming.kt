package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Timing information for the request.
 */
public data class ResourceTiming(
  @field:JsonProperty("requestTime")
  public val requestTime: Double,
  @field:JsonProperty("proxyStart")
  public val proxyStart: Double,
  @field:JsonProperty("proxyEnd")
  public val proxyEnd: Double,
  @field:JsonProperty("dnsStart")
  public val dnsStart: Double,
  @field:JsonProperty("dnsEnd")
  public val dnsEnd: Double,
  @field:JsonProperty("connectStart")
  public val connectStart: Double,
  @field:JsonProperty("connectEnd")
  public val connectEnd: Double,
  @field:JsonProperty("sslStart")
  public val sslStart: Double,
  @field:JsonProperty("sslEnd")
  public val sslEnd: Double,
  @field:JsonProperty("workerStart")
  @param:Experimental
  public val workerStart: Double,
  @field:JsonProperty("workerReady")
  @param:Experimental
  public val workerReady: Double,
  @field:JsonProperty("workerFetchStart")
  @param:Experimental
  public val workerFetchStart: Double,
  @field:JsonProperty("workerRespondWithSettled")
  @param:Experimental
  public val workerRespondWithSettled: Double,
  @field:JsonProperty("sendStart")
  public val sendStart: Double,
  @field:JsonProperty("sendEnd")
  public val sendEnd: Double,
  @field:JsonProperty("pushStart")
  @param:Experimental
  public val pushStart: Double,
  @field:JsonProperty("pushEnd")
  @param:Experimental
  public val pushEnd: Double,
  @field:JsonProperty("receiveHeadersEnd")
  public val receiveHeadersEnd: Double,
)
