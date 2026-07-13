@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Selector list data.
 */
@Serializable
data class SelectorList(
  @property:SerialName("selectors")
  val selectors: List<Value>,
  @property:SerialName("text")
  val text: String,
)
