@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.tracing.StreamCompression
import ai.platon.cdt.kt.serialization.protocol.types.tracing.StreamFormat
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Signals that tracing is stopped and there is no trace buffers pending flush, all data were
 * delivered via dataCollected events.
 */
@Serializable
data class TracingComplete(
  @property:SerialName("dataLossOccurred")
  val dataLossOccurred: Boolean,
  @property:SerialName("stream")
  @param:Optional
  val stream: String? = null,
  @property:SerialName("traceFormat")
  @param:Optional
  val traceFormat: StreamFormat? = null,
  @property:SerialName("streamCompression")
  @param:Optional
  val streamCompression: StreamCompression? = null,
)
