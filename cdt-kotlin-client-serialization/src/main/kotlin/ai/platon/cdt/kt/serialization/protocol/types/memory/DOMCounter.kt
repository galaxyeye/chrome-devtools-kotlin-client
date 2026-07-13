@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DOM object counter data.
 */
@Serializable
data class DOMCounter(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("count")
  val count: Int,
)
