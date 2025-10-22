package ai.platon.cdt.kt.protocol.events.runtime

import ai.platon.cdt.kt.protocol.types.runtime.ExceptionDetails
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

/**
 * Issued when exception was thrown and unhandled.
 */
public data class ExceptionThrown(
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
  @field:JsonProperty("exceptionDetails")
  public val exceptionDetails: ExceptionDetails,
)
