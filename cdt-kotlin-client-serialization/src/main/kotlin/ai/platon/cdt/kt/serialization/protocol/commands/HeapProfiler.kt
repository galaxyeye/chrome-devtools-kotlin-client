@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.heapprofiler.AddHeapSnapshotChunk
import ai.platon.cdt.kt.serialization.protocol.events.heapprofiler.HeapStatsUpdate
import ai.platon.cdt.kt.serialization.protocol.events.heapprofiler.LastSeenObjectId
import ai.platon.cdt.kt.serialization.protocol.events.heapprofiler.ReportHeapSnapshotProgress
import ai.platon.cdt.kt.serialization.protocol.events.heapprofiler.ResetProfiles
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.cdt.kt.serialization.protocol.types.heapprofiler.SamplingHeapProfile
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit

@Experimental
interface HeapProfiler {
  /**
   * Enables console to refer to the node with given id via $x (see Command Line API for more details
   * $x functions).
   * @param heapObjectId Heap snapshot object id to be accessible by means of $x command line API.
   */
  suspend fun addInspectedHeapObject(@ParamName("heapObjectId") heapObjectId: String)

  suspend fun collectGarbage()

  suspend fun disable()

  suspend fun enable()

  /**
   * @param objectId Identifier of the object to get heap object id for.
   */
  @Returns("heapSnapshotObjectId")
  suspend fun getHeapObjectId(@ParamName("objectId") objectId: String): String

  /**
   * @param objectId
   * @param objectGroup Symbolic group name that can be used to release multiple objects.
   */
  @Returns("result")
  suspend fun getObjectByHeapObjectId(@ParamName("objectId") objectId: String, @ParamName("objectGroup") @Optional objectGroup: String? = null): RemoteObject

  @Returns("result")
  suspend fun getObjectByHeapObjectId(@ParamName("objectId") objectId: String): RemoteObject {
    return getObjectByHeapObjectId(objectId, null)
  }

  @Returns("profile")
  suspend fun getSamplingProfile(): SamplingHeapProfile

  /**
   * @param samplingInterval Average sample interval in bytes. Poisson distribution is used for the intervals. The
   * default value is 32768 bytes.
   * @param stackDepth Maximum stack depth. The default value is 128.
   * @param includeObjectsCollectedByMajorGC By default, the sampling heap profiler reports only objects which are
   * still alive when the profile is returned via getSamplingProfile or
   * stopSampling, which is useful for determining what functions contribute
   * the most to steady-state memory usage. This flag instructs the sampling
   * heap profiler to also include information about objects discarded by
   * major GC, which will show which functions cause large temporary memory
   * usage or long GC pauses.
   * @param includeObjectsCollectedByMinorGC By default, the sampling heap profiler reports only objects which are
   * still alive when the profile is returned via getSamplingProfile or
   * stopSampling, which is useful for determining what functions contribute
   * the most to steady-state memory usage. This flag instructs the sampling
   * heap profiler to also include information about objects discarded by
   * minor GC, which is useful when tuning a latency-sensitive application
   * for minimal GC activity.
   */
  suspend fun startSampling(
    @ParamName("samplingInterval") @Optional samplingInterval: Double? = null,
    @ParamName("stackDepth") @Optional stackDepth: Double? = null,
    @ParamName("includeObjectsCollectedByMajorGC") @Optional includeObjectsCollectedByMajorGC: Boolean? = null,
    @ParamName("includeObjectsCollectedByMinorGC") @Optional includeObjectsCollectedByMinorGC: Boolean? = null,
  )

  suspend fun startSampling() {
    return startSampling(null, null, null, null)
  }

  /**
   * @param trackAllocations
   */
  suspend fun startTrackingHeapObjects(@ParamName("trackAllocations") @Optional trackAllocations: Boolean? = null)

  suspend fun startTrackingHeapObjects() {
    return startTrackingHeapObjects(null)
  }

  @Returns("profile")
  suspend fun stopSampling(): SamplingHeapProfile

  /**
   * @param reportProgress If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
   * when the tracking is stopped.
   * @param treatGlobalObjectsAsRoots Deprecated in favor of `exposeInternals`.
   * @param captureNumericValue If true, numerical values are included in the snapshot
   * @param exposeInternals If true, exposes internals of the snapshot.
   */
  suspend fun stopTrackingHeapObjects(
    @ParamName("reportProgress") @Optional reportProgress: Boolean? = null,
    @ParamName("treatGlobalObjectsAsRoots") @Optional treatGlobalObjectsAsRoots: Boolean? = null,
    @ParamName("captureNumericValue") @Optional captureNumericValue: Boolean? = null,
    @ParamName("exposeInternals") @Optional @Experimental exposeInternals: Boolean? = null,
  )

  suspend fun stopTrackingHeapObjects() {
    return stopTrackingHeapObjects(null, null, null, null)
  }

  /**
   * @param reportProgress If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken.
   * @param treatGlobalObjectsAsRoots If true, a raw snapshot without artificial roots will be generated.
   * Deprecated in favor of `exposeInternals`.
   * @param captureNumericValue If true, numerical values are included in the snapshot
   * @param exposeInternals If true, exposes internals of the snapshot.
   */
  suspend fun takeHeapSnapshot(
    @ParamName("reportProgress") @Optional reportProgress: Boolean? = null,
    @ParamName("treatGlobalObjectsAsRoots") @Optional treatGlobalObjectsAsRoots: Boolean? = null,
    @ParamName("captureNumericValue") @Optional captureNumericValue: Boolean? = null,
    @ParamName("exposeInternals") @Optional @Experimental exposeInternals: Boolean? = null,
  )

  suspend fun takeHeapSnapshot() {
    return takeHeapSnapshot(null, null, null, null)
  }

  @EventName("addHeapSnapshotChunk")
  fun onAddHeapSnapshotChunk(eventListener: EventHandler<AddHeapSnapshotChunk>): EventListener

  @EventName("addHeapSnapshotChunk")
  fun onAddHeapSnapshotChunk(eventListener: suspend (AddHeapSnapshotChunk) -> Unit): EventListener

  @EventName("heapStatsUpdate")
  fun onHeapStatsUpdate(eventListener: EventHandler<HeapStatsUpdate>): EventListener

  @EventName("heapStatsUpdate")
  fun onHeapStatsUpdate(eventListener: suspend (HeapStatsUpdate) -> Unit): EventListener

  @EventName("lastSeenObjectId")
  fun onLastSeenObjectId(eventListener: EventHandler<LastSeenObjectId>): EventListener

  @EventName("lastSeenObjectId")
  fun onLastSeenObjectId(eventListener: suspend (LastSeenObjectId) -> Unit): EventListener

  @EventName("reportHeapSnapshotProgress")
  fun onReportHeapSnapshotProgress(eventListener: EventHandler<ReportHeapSnapshotProgress>): EventListener

  @EventName("reportHeapSnapshotProgress")
  fun onReportHeapSnapshotProgress(eventListener: suspend (ReportHeapSnapshotProgress) -> Unit): EventListener

  @EventName("resetProfiles")
  fun onResetProfiles(eventListener: EventHandler<ResetProfiles>): EventListener

  @EventName("resetProfiles")
  fun onResetProfiles(eventListener: suspend (ResetProfiles) -> Unit): EventListener
}
