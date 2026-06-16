@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Location in the source code.
 */
@Serializable
data class Location(
  @property:SerialName("scriptId")
  val scriptId: String,
  @property:SerialName("lineNumber")
  val lineNumber: Int,
  @property:SerialName("columnNumber")
  @param:Optional
  val columnNumber: Int? = null,
)
