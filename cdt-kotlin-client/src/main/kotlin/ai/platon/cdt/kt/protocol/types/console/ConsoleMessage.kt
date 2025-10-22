package ai.platon.cdt.kt.protocol.types.console

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Console message.
 */
data class ConsoleMessage(
  @field:JsonProperty("source")
  val source: ConsoleMessageSource,
  @field:JsonProperty("level")
  val level: ConsoleMessageLevel,
  @field:JsonProperty("text")
  val text: String,
  @field:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @field:JsonProperty("line")
  @param:Optional
  val line: Int? = null,
  @field:JsonProperty("column")
  @param:Optional
  val column: Int? = null,
)
