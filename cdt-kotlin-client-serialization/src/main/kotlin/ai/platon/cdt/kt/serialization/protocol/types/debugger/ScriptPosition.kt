@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Location in the source code.
 */
@Serializable
@Experimental
data class ScriptPosition(
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  val columnNumber: Int,
)
