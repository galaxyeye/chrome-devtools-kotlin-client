@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Search match for resource.
 */
@Serializable
data class SearchMatch(
  @property:SerialName("lineNumber")
  val lineNumber: Double,
  @property:SerialName("lineContent")
  val lineContent: String,
)
