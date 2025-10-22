package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has finished loading.
 */
data class LoadingFinished(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("timestamp")
  val timestamp: Double,
  @field:JsonProperty("encodedDataLength")
  val encodedDataLength: Double,
  @field:JsonProperty("shouldReportCorbBlocking")
  @param:Optional
  val shouldReportCorbBlocking: Boolean? = null,
)
