@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BreakLocation(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  @param:Optional
  val columnNumber: Int? = null,
  @property:SerialName("type")
  @param:Optional
  val type: BreakLocationType? = null,
)
