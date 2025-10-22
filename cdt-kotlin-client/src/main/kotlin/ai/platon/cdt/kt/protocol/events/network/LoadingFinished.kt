package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Fired when HTTP request has finished loading.
 */
public data class LoadingFinished(
  @field:JsonProperty("requestId")
  public val requestId: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("encodedDataLength")
  public val encodedDataLength: Double,
  @field:JsonProperty("shouldReportCorbBlocking")
  @param:Optional
  public val shouldReportCorbBlocking: Boolean? = null,
)
