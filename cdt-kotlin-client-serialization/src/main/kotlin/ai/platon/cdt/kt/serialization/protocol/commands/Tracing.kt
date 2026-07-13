@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.tracing.BufferUsage
import ai.platon.cdt.kt.serialization.protocol.events.tracing.DataCollected
import ai.platon.cdt.kt.serialization.protocol.events.tracing.TracingComplete
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.cdt.kt.serialization.protocol.types.tracing.MemoryDumpLevelOfDetail
import ai.platon.cdt.kt.serialization.protocol.types.tracing.RequestMemoryDump
import ai.platon.cdt.kt.serialization.protocol.types.tracing.StartTransferMode
import ai.platon.cdt.kt.serialization.protocol.types.tracing.StreamCompression
import ai.platon.cdt.kt.serialization.protocol.types.tracing.StreamFormat
import ai.platon.cdt.kt.serialization.protocol.types.tracing.TraceConfig
import ai.platon.cdt.kt.serialization.protocol.types.tracing.TracingBackend
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

interface Tracing {
  /**
   * Stop trace events collection.
   */
  suspend fun end()

  /**
   * Gets supported tracing categories.
   */
  @Experimental
  @Returns("categories")
  @ReturnTypeParameter(String::class)
  suspend fun getCategories(): List<String>

  /**
   * Return a descriptor for all available tracing categories.
   */
  @Experimental
  @Returns("descriptor")
  suspend fun getTrackEventDescriptor(): String

  /**
   * Record a clock sync marker in the trace.
   * @param syncId The ID of this clock sync marker
   */
  @Experimental
  suspend fun recordClockSyncMarker(@ParamName("syncId") syncId: String)

  /**
   * Request a global memory dump.
   * @param deterministic Enables more deterministic results by forcing garbage collection
   * @param levelOfDetail Specifies level of details in memory dump. Defaults to "detailed".
   */
  @Experimental
  suspend fun requestMemoryDump(@ParamName("deterministic") @Optional deterministic: Boolean? = null, @ParamName("levelOfDetail") @Optional levelOfDetail: MemoryDumpLevelOfDetail? = null): RequestMemoryDump

  @Experimental
  suspend fun requestMemoryDump(): RequestMemoryDump {
    return requestMemoryDump(null, null)
  }

  /**
   * Start trace events collection.
   * @param categories Category/tag filter
   * @param options Tracing options
   * @param bufferUsageReportingInterval If set, the agent will issue bufferUsage events at this interval, specified in milliseconds
   * @param transferMode Whether to report trace events as series of dataCollected events or to save trace to a
   * stream (defaults to `ReportEvents`).
   * @param streamFormat Trace data format to use. This only applies when using `ReturnAsStream`
   * transfer mode (defaults to `json`).
   * @param streamCompression Compression format to use. This only applies when using `ReturnAsStream`
   * transfer mode (defaults to `none`)
   * @param traceConfig
   * @param perfettoConfig Base64-encoded serialized perfetto.protos.TraceConfig protobuf message
   * When specified, the parameters `categories`, `options`, `traceConfig`
   * are ignored. (Encoded as a base64 string when passed over JSON)
   * @param tracingBackend Backend type (defaults to `auto`)
   */
  suspend fun start(
    @ParamName("categories") @Optional @Experimental categories: String? = null,
    @ParamName("options") @Optional @Experimental options: String? = null,
    @ParamName("bufferUsageReportingInterval") @Optional @Experimental bufferUsageReportingInterval: Double? = null,
    @ParamName("transferMode") @Optional transferMode: StartTransferMode? = null,
    @ParamName("streamFormat") @Optional streamFormat: StreamFormat? = null,
    @ParamName("streamCompression") @Optional @Experimental streamCompression: StreamCompression? = null,
    @ParamName("traceConfig") @Optional traceConfig: TraceConfig? = null,
    @ParamName("perfettoConfig") @Optional @Experimental perfettoConfig: String? = null,
    @ParamName("tracingBackend") @Optional @Experimental tracingBackend: TracingBackend? = null,
  )

  suspend fun start() {
    return start(null, null, null, null, null, null, null, null, null)
  }

  @EventName("bufferUsage")
  @Experimental
  fun onBufferUsage(eventListener: EventHandler<BufferUsage>): EventListener

  @EventName("bufferUsage")
  @Experimental
  fun onBufferUsage(eventListener: suspend (BufferUsage) -> Unit): EventListener

  @EventName("dataCollected")
  @Experimental
  fun onDataCollected(eventListener: EventHandler<DataCollected>): EventListener

  @EventName("dataCollected")
  @Experimental
  fun onDataCollected(eventListener: suspend (DataCollected) -> Unit): EventListener

  @EventName("tracingComplete")
  fun onTracingComplete(eventListener: EventHandler<TracingComplete>): EventListener

  @EventName("tracingComplete")
  fun onTracingComplete(eventListener: suspend (TracingComplete) -> Unit): EventListener
}
