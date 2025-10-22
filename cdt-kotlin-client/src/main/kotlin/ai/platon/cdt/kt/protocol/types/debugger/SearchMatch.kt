package ai.platon.cdt.kt.protocol.types.debugger

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Search match for resource.
 */
data class SearchMatch(
  @field:JsonProperty("lineNumber")
  val lineNumber: Double,
  @field:JsonProperty("lineContent")
  val lineContent: String,
)
