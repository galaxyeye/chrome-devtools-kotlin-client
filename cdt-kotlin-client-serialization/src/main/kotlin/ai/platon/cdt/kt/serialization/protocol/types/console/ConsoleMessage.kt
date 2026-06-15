@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.console
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

/**
 * Console message.
 */
@Serializable
data class ConsoleMessage(
  @SerialName("source")
  val source: ConsoleMessageSource,
  @SerialName("level")
  val level: ConsoleMessageLevel,
  @SerialName("text")
  val text: String,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("line")
  @param:Optional
  val line: Int? = null,
  @SerialName("column")
  @param:Optional
  val column: Int? = null,
)
