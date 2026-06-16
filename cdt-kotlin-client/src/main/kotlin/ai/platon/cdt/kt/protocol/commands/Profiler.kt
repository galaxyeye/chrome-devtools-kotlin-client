@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.profiler.ConsoleProfileFinished
import ai.platon.cdt.kt.protocol.events.profiler.ConsoleProfileStarted
import ai.platon.cdt.kt.protocol.events.profiler.PreciseCoverageDeltaUpdate
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.profiler.Profile
import ai.platon.cdt.kt.protocol.types.profiler.ScriptCoverage
import ai.platon.cdt.kt.protocol.types.profiler.TakePreciseCoverage
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Unit
import kotlin.collections.List

interface Profiler {
  suspend fun disable()

  suspend fun enable()

  /**
   * Collect coverage data for the current isolate. The coverage data may be incomplete due to
   * garbage collection.
   */
  @Returns("result")
  @ReturnTypeParameter(ScriptCoverage::class)
  suspend fun getBestEffortCoverage(): List<ScriptCoverage>

  /**
   * Changes CPU profiler sampling interval. Must be called before CPU profiles recording started.
   * @param interval New sampling interval in microseconds.
   */
  suspend fun setSamplingInterval(@ParamName("interval") interval: Int)

  suspend fun start()

  /**
   * Enable precise code coverage. Coverage data for JavaScript executed before enabling precise code
   * coverage may be incomplete. Enabling prevents running optimized code and resets execution
   * counters.
   * @param callCount Collect accurate call counts beyond simple 'covered' or 'not covered'.
   * @param detailed Collect block-based coverage.
   * @param allowTriggeredUpdates Allow the backend to send updates on its own initiative
   */
  @Returns("timestamp")
  suspend fun startPreciseCoverage(
    @ParamName("callCount") @Optional callCount: Boolean? = null,
    @ParamName("detailed") @Optional detailed: Boolean? = null,
    @ParamName("allowTriggeredUpdates") @Optional allowTriggeredUpdates: Boolean? = null,
  ): Double

  @Returns("timestamp")
  suspend fun startPreciseCoverage(): Double {
    return startPreciseCoverage(null, null, null)
  }

  @Returns("profile")
  suspend fun stop(): Profile

  /**
   * Disable precise code coverage. Disabling releases unnecessary execution count records and allows
   * executing optimized code.
   */
  suspend fun stopPreciseCoverage()

  /**
   * Collect coverage data for the current isolate, and resets execution counters. Precise code
   * coverage needs to have started.
   */
  suspend fun takePreciseCoverage(): TakePreciseCoverage

  @EventName("consoleProfileFinished")
  fun onConsoleProfileFinished(eventListener: EventHandler<ConsoleProfileFinished>): EventListener

  @EventName("consoleProfileFinished")
  fun onConsoleProfileFinished(eventListener: suspend (ConsoleProfileFinished) -> Unit): EventListener

  @EventName("consoleProfileStarted")
  fun onConsoleProfileStarted(eventListener: EventHandler<ConsoleProfileStarted>): EventListener

  @EventName("consoleProfileStarted")
  fun onConsoleProfileStarted(eventListener: suspend (ConsoleProfileStarted) -> Unit): EventListener

  @EventName("preciseCoverageDeltaUpdate")
  @Experimental
  fun onPreciseCoverageDeltaUpdate(eventListener: EventHandler<PreciseCoverageDeltaUpdate>): EventListener

  @EventName("preciseCoverageDeltaUpdate")
  @Experimental
  fun onPreciseCoverageDeltaUpdate(eventListener: suspend (PreciseCoverageDeltaUpdate) -> Unit): EventListener
}
