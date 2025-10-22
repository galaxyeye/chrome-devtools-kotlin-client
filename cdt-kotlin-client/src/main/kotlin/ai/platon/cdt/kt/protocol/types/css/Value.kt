package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Data for a simple selector (these are delimited by commas in a selector list).
 */
public data class Value(
  @field:JsonProperty("text")
  public val text: String,
  @field:JsonProperty("range")
  @param:Optional
  public val range: SourceRange? = null,
)
