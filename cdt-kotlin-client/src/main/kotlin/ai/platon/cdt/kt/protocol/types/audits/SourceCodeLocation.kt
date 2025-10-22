package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class SourceCodeLocation(
  @field:JsonProperty("scriptId")
  @param:Optional
  public val scriptId: String? = null,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("lineNumber")
  public val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  public val columnNumber: Int,
)
