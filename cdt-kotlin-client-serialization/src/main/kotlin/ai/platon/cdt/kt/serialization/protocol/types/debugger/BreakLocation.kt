@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class BreakLocation(
  @SerialName("scriptId")
  val scriptId: String,
  @SerialName("lineNumber")
  val lineNumber: Int,
  @SerialName("columnNumber")
  @param:Optional
  val columnNumber: Int? = null,
  @SerialName("type")
  @param:Optional
  val type: BreakLocationType? = null,
)
