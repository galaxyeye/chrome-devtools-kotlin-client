package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Error while paring app manifest.
 */
public data class AppManifestError(
  @field:JsonProperty("message")
  public val message: String,
  @field:JsonProperty("critical")
  public val critical: Int,
  @field:JsonProperty("line")
  public val line: Int,
  @field:JsonProperty("column")
  public val column: Int,
)
