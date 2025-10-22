package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class SourceCodeLocation(
  @field:JsonProperty("scriptId")
  @param:Optional
  val scriptId: String? = null,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("lineNumber")
  val lineNumber: Int,
  @field:JsonProperty("columnNumber")
  val columnNumber: Int,
)
