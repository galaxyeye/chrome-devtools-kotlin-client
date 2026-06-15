@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String
import kotlin.collections.List

/**
 * Selector list data.
 */
@Serializable
data class SelectorList(
  @SerialName("selectors")
  val selectors: List<Value>,
  @SerialName("text")
  val text: String,
)
