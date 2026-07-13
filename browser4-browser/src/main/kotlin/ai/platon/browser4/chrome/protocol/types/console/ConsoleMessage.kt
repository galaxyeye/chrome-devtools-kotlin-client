@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.console

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Console message.
 */
@Serializable
data class ConsoleMessage(
  @property:SerialName("source")
  val source: ConsoleMessageSource,
  @property:SerialName("level")
  val level: ConsoleMessageLevel,
  @property:SerialName("text")
  val text: String,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("line")
  @param:Optional
  val line: Int? = null,
  @property:SerialName("column")
  @param:Optional
  val column: Int? = null,
)
