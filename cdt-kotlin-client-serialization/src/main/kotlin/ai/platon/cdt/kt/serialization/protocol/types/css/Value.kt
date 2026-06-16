@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data for a simple selector (these are delimited by commas in a selector list).
 */
@Serializable
data class Value(
  @property:SerialName("text")
  val text: String,
  @property:SerialName("range")
  @param:Optional
  val range: SourceRange? = null,
)
