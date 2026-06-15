@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Fired when `Element`'s attribute is modified.
 */
@Serializable
data class AttributeModified(
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
