@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when `Element`'s attribute is modified.
 */
@Serializable
data class AttributeModified(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
