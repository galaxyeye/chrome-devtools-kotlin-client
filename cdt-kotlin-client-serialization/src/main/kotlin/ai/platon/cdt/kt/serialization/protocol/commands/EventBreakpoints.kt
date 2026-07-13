@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import kotlin.String

/**
 * EventBreakpoints permits setting JavaScript breakpoints on operations and events
 * occurring in native code invoked from JavaScript. Once breakpoint is hit, it is
 * reported through Debugger domain, similarly to regular breakpoints being hit.
 */
@Experimental
interface EventBreakpoints {
  /**
   * Sets breakpoint on particular native event.
   * @param eventName Instrumentation name to stop on.
   */
  suspend fun setInstrumentationBreakpoint(@ParamName("eventName") eventName: String)

  /**
   * Removes breakpoint on particular native event.
   * @param eventName Instrumentation name to stop on.
   */
  suspend fun removeInstrumentationBreakpoint(@ParamName("eventName") eventName: String)

  /**
   * Removes all breakpoints
   */
  suspend fun disable()
}
