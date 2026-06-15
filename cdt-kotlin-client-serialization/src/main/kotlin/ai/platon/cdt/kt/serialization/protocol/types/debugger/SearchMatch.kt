@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.debugger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Search match for resource.
 */
@Serializable
data class SearchMatch(
  @SerialName("lineNumber")
  val lineNumber: Double,
  @SerialName("lineContent")
  val lineContent: String,
)
