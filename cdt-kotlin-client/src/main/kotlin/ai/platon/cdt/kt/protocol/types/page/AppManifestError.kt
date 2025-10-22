package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Error while paring app manifest.
 */
data class AppManifestError(
  @field:JsonProperty("message")
  val message: String,
  @field:JsonProperty("critical")
  val critical: Int,
  @field:JsonProperty("line")
  val line: Int,
  @field:JsonProperty("column")
  val column: Int,
)
