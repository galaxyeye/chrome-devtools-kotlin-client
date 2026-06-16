@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.types.systeminfo.Info
import ai.platon.cdt.kt.serialization.protocol.types.systeminfo.ProcessInfo
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * The SystemInfo domain defines methods and events for querying low-level system information.
 */
@Experimental
interface SystemInfo {
  /**
   * Returns information about the system.
   */
  suspend fun getInfo(): Info

  /**
   * Returns information about the feature state.
   * @param featureState
   */
  @Returns("featureEnabled")
  suspend fun getFeatureState(@ParamName("featureState") featureState: String): Boolean

  /**
   * Returns information about all running processes.
   */
  @Returns("processInfo")
  @ReturnTypeParameter(ProcessInfo::class)
  suspend fun getProcessInfo(): List<ProcessInfo>
}
