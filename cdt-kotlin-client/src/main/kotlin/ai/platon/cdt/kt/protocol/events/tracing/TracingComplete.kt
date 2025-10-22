package ai.platon.cdt.kt.protocol.events.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.tracing.StreamCompression
import ai.platon.cdt.kt.protocol.types.tracing.StreamFormat
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
 * delivered via dataCollected events.
 */
data class TracingComplete(
  @field:JsonProperty("dataLossOccurred")
  val dataLossOccurred: Boolean,
  @field:JsonProperty("stream")
  @param:Optional
  val stream: String? = null,
  @field:JsonProperty("traceFormat")
  @param:Optional
  val traceFormat: StreamFormat? = null,
  @field:JsonProperty("streamCompression")
  @param:Optional
  val streamCompression: StreamCompression? = null,
)
