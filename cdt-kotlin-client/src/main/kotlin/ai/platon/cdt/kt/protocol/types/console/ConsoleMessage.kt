package ai.platon.cdt.kt.protocol.types.console

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Console message.
 */
public data class ConsoleMessage(
  @field:JsonProperty("source")
  public val source: ConsoleMessageSource,
  @field:JsonProperty("level")
  public val level: ConsoleMessageLevel,
  @field:JsonProperty("text")
  public val text: String,
  @field:JsonProperty("url")
  @param:Optional
  public val url: String? = null,
  @field:JsonProperty("line")
  @param:Optional
  public val line: Int? = null,
  @field:JsonProperty("column")
  @param:Optional
  public val column: Int? = null,
)
