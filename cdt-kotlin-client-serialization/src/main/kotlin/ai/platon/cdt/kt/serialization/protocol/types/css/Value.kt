@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Data for a simple selector (these are delimited by commas in a selector list).
 */
@Serializable
data class Value(
  @SerialName("text")
  val text: String,
  @SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
)
